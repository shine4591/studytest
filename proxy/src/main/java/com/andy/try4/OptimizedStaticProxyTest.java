package com.andy.try4;

import com.andy.service.Service;
import com.andy.service.impl.ServiceImpl;
import com.andy.try4.handler.LoggerHandler;
import com.andy.try4.handler.TimeHandler;
import com.andy.try4.serviceimpl.OptimizedProxyService;

public class OptimizedStaticProxyTest {

    public static void main(String[] args) {

        Service s = new ServiceImpl();
        s = new OptimizedProxyService(s, new LoggerHandler());
        s = new OptimizedProxyService(s, new TimeHandler());
        System.out.println(s.getClass().getName());
        s.getUp();
        s.haveBreakfast();
        s.haveLunch();
        s.haveSupper();
        s.goToBed();
        System.out.println("optimized static proxy call done...");

    }

}
