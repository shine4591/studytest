package com.andy.try4.handler;

import com.andy.try4.InvokeHandler;

import java.lang.reflect.Method;

// 增加日志的实现
public class LoggerHandler implements InvokeHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        System.out.println("before [" + name + "]");
        Object res = method.invoke(proxy, args);
        System.out.println("after [" + name + "]");
        return res;
    }

}
