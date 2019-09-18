package com.andy.try4.serviceimpl;

import com.andy.service.Service;
import com.andy.try4.InvokeHandler;
import java.lang.reflect.Method;

public class OptimizedProxyService implements Service {
    private Object target;
    private InvokeHandler logicHandler;//额外逻辑的类

    public OptimizedProxyService(Object target, InvokeHandler logicHandler) {
        this.target = target;
        this.logicHandler = logicHandler;
    }

    @Override
    public void getUp() {
        String name = "getUp";
        try {
            Method m = target.getClass().getMethod(name, new Class<?>[]{});
            logicHandler.invoke(target, m, new Object[]{});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void haveBreakfast() {
        String name = "haveBreakfast";
        try {
            Method m = target.getClass().getMethod(name, new Class<?>[]{});
            logicHandler.invoke(target, m, new Object[]{});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void haveLunch() {
        String name = "haveLunch";
        try {
            Method m = target.getClass().getMethod(name, new Class<?>[]{});
            logicHandler.invoke(target, m, new Object[]{});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void haveSupper() {
        String name = "haveSupper";
        try {
            Method m = target.getClass().getMethod(name, new Class<?>[]{});
            logicHandler.invoke(target, m, new Object[]{});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void goToBed() {
        String name = "goToBed";
        try {
            Method m = target.getClass().getMethod(name, new Class<?>[]{});
            logicHandler.invoke(target, m, new Object[]{});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
