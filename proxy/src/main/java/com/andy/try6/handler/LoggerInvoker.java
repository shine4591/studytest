package com.andy.try6.handler;

import com.andy.try9.handler.ProxyBase;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LoggerInvoker extends CgLibProxyBase {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String name = method.getName();
        System.out.println("before [" + name + "]");
        Object ret = methodProxy.invokeSuper(o,objects);
        System.out.println("after [" + name + "]");
        return ret;
    }

}
