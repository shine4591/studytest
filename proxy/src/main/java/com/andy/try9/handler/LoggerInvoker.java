package com.andy.try9.handler;

import java.lang.reflect.Method;

public class LoggerInvoker extends ProxyBase {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        System.out.println("before [" + name + "]");
        Object ret = method.invoke(getTarget(), args);
        System.out.println("after [" + name + "]");
        return ret;
    }
}
