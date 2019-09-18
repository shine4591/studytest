package com.andy.try1;

import com.andy.service.Service;
import com.andy.service.impl.ServiceImpl;

public class DirectTest {


    public static void main(String[] args) throws Exception {
        Service s = new ServiceImpl();
        System.out.println(s.getClass().getName());
        s.getUp();
        s.haveBreakfast();
        s.haveLunch();
        s.haveSupper();
        s.goToBed();
        System.out.println("Direct call done...");

    }

}
