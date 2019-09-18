package com.andy.try5.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 增加计时的实现
public class TimeInvoker implements InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        long l1 = System.currentTimeMillis();
        Object res = method.invoke(proxy, args);
        long l2 = System.currentTimeMillis();
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
        return res;
    }

}
