package com.andy.try9.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class ProxyBase implements InvocationHandler {

    private Object target;

    protected Object getTarget() {
        return target;
    }

    public static Object getInvoker(Object target, Class<?>... handlerClass) {
        Object res = target;
        try {
            ClassLoader cl = target.getClass().getClassLoader();
            Class<?>[] ifs = target.getClass().getInterfaces();
            for (Class<?> ib : handlerClass) {
                ProxyBase handler = (ProxyBase) ib.newInstance();
                handler.target = res;
                res = Proxy.newProxyInstance(cl, ifs, handler);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public abstract Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
