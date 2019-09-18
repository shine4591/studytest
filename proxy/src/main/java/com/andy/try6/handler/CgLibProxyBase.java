package com.andy.try6.handler;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


// 增加日志的实现
public abstract class CgLibProxyBase implements MethodInterceptor {

    public static Object getInstance(Class<?> implClass, Class<?>[] interceptors) throws Exception {
        MethodInterceptor[] callbacks = new MethodInterceptor[interceptors.length];
        for (int i = 0; i < interceptors.length; i++) {
            callbacks[i] = (MethodInterceptor) interceptors[i].newInstance();
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(implClass);
        enhancer.setCallbacks(callbacks);
        return enhancer.create();

//        Object res = null;
//        Class<?> c = implClass;
//        for (int i = 0; i < interceptors.length; i++) {
//            MethodInterceptor mi = (MethodInterceptor) interceptors[i].newInstance();
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(c);
//            enhancer.setCallback(mi);
//            res = enhancer.create();
//            c = res.getClass();
//        }
//        return res;

    }


    public abstract Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable;

}
