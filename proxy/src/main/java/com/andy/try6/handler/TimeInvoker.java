package com.andy.try6.handler;

import com.andy.try9.handler.ProxyBase;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimeInvoker extends CgLibProxyBase {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String name = method.getName();
        long l1 = System.currentTimeMillis();
        Object ret = methodProxy.invokeSuper(o,objects);
        long l2 = System.currentTimeMillis();
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
        return ret;
    }

}
