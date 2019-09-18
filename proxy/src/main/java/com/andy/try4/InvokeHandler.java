package com.andy.try4;

import java.lang.reflect.Method;

public interface InvokeHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
