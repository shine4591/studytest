package com.andy.try2;

import com.andy.service.Service;

public class ExtendsTest {


    public static void main(String[] args) throws Exception {
        Service s = new ServiceImplChild();
        System.out.println(s.getClass().getName());
        s.getUp();
        s.haveBreakfast();
        s.haveLunch();
        s.haveSupper();
        s.goToBed();
        System.out.println("extends call done...");

    }

}
