package com.andy.try5;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProxyGenerator {

    //生成多层代理类
    public static synchronized <E> E getProxy(Class<?> interfaceClazz, E interfaceImpl, InvocationHandler... extraLogics) throws Exception {
        E e = interfaceImpl;
        if (extraLogics == null) {
            return e;
        }
        for (InvocationHandler extraLogic : extraLogics) {
            e = getOneProxy(interfaceClazz, e, extraLogic);
        }
        return e;
    }

    //生成一层代理类
    private static <E> E getOneProxy(Class<?> ic, E iI, InvocationHandler exL) throws Exception {
        String className = getTempProxyName();
        String proxyPackage = null;
        String fullClassName = className;
        Package p = ProxyGenerator.class.getPackage();
        if (p != null) {
            proxyPackage = p.getName();
            fullClassName = proxyPackage + "." + className;
        }
        //1. 生成java代码，package默认使用当前工具类的包下
        String code = generateJavaCode(proxyPackage, className, ic);

        //2. 编译java代码，存储class文件的字节数组
        compileJavaCode(fullClassName, code);
        //3. 使用自定义的类加载器装载类
        Class<?> c = classloader.loadClass(fullClassName);
        //4. 使用构造函数生成对象
        Constructor<?> con = c.getConstructor(new Class[]{Object.class, InvocationHandler.class});
        @SuppressWarnings("unchecked")
        E e = (E) con.newInstance(new Object[]{iI, exL});
        return e;
    }


    private static int cnt = 0;

    //生成临时类名
    private static String getTempProxyName() {
        return "$Proxy_" + (cnt++);
    }

    private static String castReturnType(String returnClass) {
        switch (returnClass) {
            case "int":
                return "Integer";
            case "long":
                return "Long";
            case "byte":
                return "Byte";
            case "short":
                return "Short";
            case "float":
                return "Float";
            case "double":
                return "Double";
            case "boolean":
                return "Boolean";
            case "char":
                return "Char";
            default:
                return returnClass;
        }
    }

    private static String filterArray(Class<?> clazz) {
        if (clazz.isArray()) {
            StringBuilder sb = new StringBuilder();
            Class<?> c = clazz;
            while (c.isArray()) {
                sb.append("[]");
                c = c.getComponentType();
            }
            return c.getName() + sb;
        }
        return clazz.getName();
    }

    // 生成OptimizedProxyService的java代码
    private static String generateJavaCode(String proxyPackage, String proxyClassName, Class<?> interfaze) {
        StringBuilder sb = new StringBuilder();
        if (proxyPackage != null) {
            sb.append("package ").append(proxyPackage).append(";\n");
        }
        sb.append("import java.lang.reflect.Method;\n");
        sb.append("public final class ").append(proxyClassName).append(" implements ").append(interfaze.getName())
                .append(" {\n");
        sb.append("private Object target;\n");
        sb.append("private java.lang.reflect.InvocationHandler logicHandler;\n");
        sb.append("public ").append(proxyClassName)
                .append("(Object target, java.lang.reflect.InvocationHandler logicHandler) {\n");
        sb.append("this.target = target;\n");
        sb.append("this.logicHandler = logicHandler;\n");
        sb.append("}\n");

        Method[] ms = interfaze.getMethods();
        for (Method m : ms) {
            String methodName = m.getName();
            String returnClass = filterArray(m.getReturnType());
            boolean isVoid = returnClass.equals("void");
            sb.append("public final ").append(returnClass).append(" ").append(methodName);

            sb.append("(");
            Class<?>[] paramClass = m.getParameterTypes();
            int len = paramClass.length;
            StringBuilder clazzP = new StringBuilder();
            StringBuilder objectP = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (i >= 1) {
                    sb.append(", ");
                    clazzP.append(", ");
                    objectP.append(", ");
                }
                String paramName = filterArray(paramClass[i]);
                clazzP.append(paramName).append(".class");
                sb.append(paramName).append(" ").append("p_").append(i);
                objectP.append("p_").append(i);
            }
            sb.append(") {\n");
            sb.append("final String name = \"").append(methodName).append("\";\n");
            sb.append("try {\n");
            sb.append("Method m = target.getClass().getMethod(name, new Class<?>[]{").append(clazzP).append("});\n");
            if (!isVoid) {
                sb.append("return (").append(castReturnType(returnClass)).append(")");
            }
            sb.append("logicHandler.invoke(target, m, new Object[]{").append(objectP).append("});\n");
            sb.append("} catch (Throwable e) {\n");
            sb.append("throw new RuntimeException(e);\n");
            sb.append("}\n");
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

    private static class StringSourceJavaObject extends SimpleJavaFileObject {
        private String content = null;
        private ByteArrayOutputStream outPutStream = new ByteArrayOutputStream();

        public StringSourceJavaObject(String fullClassName, String content) throws URISyntaxException {
            super(URI.create("string:///" + fullClassName.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.content = content;
        }

        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return content;
        }

        public OutputStream openOutputStream() throws IOException {
            return outPutStream;
        }

        public byte[] getCompiledBytes() {
            return outPutStream.toByteArray();
        }
    }

    private static class StringJavaFileManager extends ForwardingJavaFileManager<StandardJavaFileManager> {
        private StringSourceJavaObject sourceObject;

        public StringJavaFileManager(StandardJavaFileManager fileManager, StringSourceJavaObject sourceObject) {
            super(fileManager);
            this.sourceObject = sourceObject;
        }

        @Override
        public JavaFileObject getJavaFileForInput(Location location, String className, JavaFileObject.Kind kind)
                throws IOException {
            return sourceObject;
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind,
                                                   FileObject sibling) throws IOException {
            return sourceObject;
        }
    }


    private static Map<String, byte[]> map = new ConcurrentHashMap<>();
    private static ClassLoader classloader = new ProxyClassLoader();

    private static class ProxyClassLoader extends ClassLoader {
        protected Class<?> findClass(String fullClassName) throws ClassNotFoundException {
            byte[] bs = map.get(fullClassName);
            if (bs == null) {
                throw new ClassNotFoundException(fullClassName);
            }
            return this.defineClass(fullClassName, bs, 0, bs.length);
        }
    }

    private static JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    private static void compileJavaCode(String fullClassName, String javaCode) throws Exception {
        if (map.containsKey(fullClassName)) {
            return;
        }
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        StringSourceJavaObject sourceObject = new StringSourceJavaObject(fullClassName, javaCode);
        StringJavaFileManager stringFileManager = new StringJavaFileManager(fileManager, sourceObject);
        JavaCompiler.CompilationTask task = compiler.getTask(null, stringFileManager, null, null, null, Arrays.asList(sourceObject));
        boolean result = task.call();
        if (result) {
            byte[] bs = sourceObject.getCompiledBytes();
            map.put(fullClassName, bs);
        } else {
            throw new Exception("Compile failed...");
        }
    }

}
