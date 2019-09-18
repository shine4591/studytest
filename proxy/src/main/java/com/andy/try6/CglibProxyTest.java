package com.andy.try6;

import com.andy.service.Service;
import com.andy.service.impl.ServiceImpl;
import com.andy.try6.handler.LoggerInvoker;
import com.andy.try6.handler.CgLibProxyBase;
import com.andy.try6.handler.TimeInvoker;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibProxyTest {

    public static void main(String[] args) throws Exception {
        Service s = (Service) CgLibProxyBase.getInstance(ServiceImpl.class, new Class<?>[]{LoggerInvoker.class, TimeInvoker.class});
        System.out.println(s.getClass().getName());
        s.getUp();
        s.haveBreakfast();
        s.haveLunch();
        s.haveSupper();
        s.goToBed();
        System.out.println("cglib proxy call done...");
    }

}
