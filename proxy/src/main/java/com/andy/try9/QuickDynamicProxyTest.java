package com.andy.try9;

import com.andy.service.Service;
import com.andy.service.impl.ServiceImpl;
import com.andy.try9.handler.LoggerInvoker;
import com.andy.try9.handler.ProxyBase;
import com.andy.try9.handler.TimeInvoker;

public class QuickDynamicProxyTest {

    public static void main(String[] args) throws Exception {
        Service s = (Service) ProxyBase.getInvoker(new ServiceImpl(), LoggerInvoker.class, TimeInvoker.class);
        System.out.println(s.getClass().getName());
        s.getUp();
        s.haveBreakfast();
        s.haveLunch();
        s.haveSupper();
        s.goToBed();
        System.out.println("quick dynamic proxy call done...");
    }

}
