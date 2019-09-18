package com.andy.try9.handler;

import java.lang.reflect.Method;

public class TimeInvoker extends ProxyBase {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        long l1 = System.currentTimeMillis();
        Object ret = method.invoke(getTarget(), args);
        long l2 = System.currentTimeMillis();
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
        return ret;
    }
}
