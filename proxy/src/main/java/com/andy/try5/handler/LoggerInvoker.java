package com.andy.try5.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
// 增加日志的实现
public class LoggerInvoker implements InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        System.out.println("before [" + name + "]");
        Object res = method.invoke(proxy, args);
        System.out.println("after [" + name + "]");
        return res;
    }

}
