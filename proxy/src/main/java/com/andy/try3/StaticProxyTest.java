package com.andy.try3;

import com.andy.service.Service;
import com.andy.service.impl.ServiceImpl;

public class StaticProxyTest {


    public static void main(String[] args) throws Exception {
        Service s = new ServiceImpl();
        s = new LoggerProxyService(s);
        s = new TimeProxyService(s);
        System.out.println(s.getClass().getName());
        s.getUp();
        s.haveBreakfast();
        s.haveLunch();
        s.haveSupper();
        s.goToBed();
        System.out.println("static proxy call done...");

    }

}
