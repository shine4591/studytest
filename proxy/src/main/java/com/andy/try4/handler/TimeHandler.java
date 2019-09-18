package com.andy.try4.handler;

import com.andy.try4.InvokeHandler;

import java.lang.reflect.Method;

// 增加计时的实现
public class TimeHandler implements InvokeHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        long l1 = System.currentTimeMillis();
        Object res = method.invoke(proxy, args);
        long l2 = System.currentTimeMillis();
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
        return res;
    }

}
