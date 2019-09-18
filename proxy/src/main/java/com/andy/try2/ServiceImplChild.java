package com.andy.try2;

import com.andy.service.impl.ServiceImpl;

public class ServiceImplChild extends ServiceImpl {

    @Override
    public void getUp() {
        String name = "getUp";
        System.out.println("before [" + name + "]");
        long l1 = System.currentTimeMillis();
        super.getUp();
        long l2 = System.currentTimeMillis();
        System.out.println("after [" + name + "]");
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
    }

    @Override
    public void haveBreakfast() {
        String name = "haveBreakfast";
        System.out.println("before [" + name + "]");
        long l1 = System.currentTimeMillis();
        super.haveBreakfast();
        long l2 = System.currentTimeMillis();
        System.out.println("after [" + name + "]");
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
    }

    @Override
    public void haveLunch() {
        String name = "haveLunch";
        System.out.println("before [" + name + "]");
        long l1 = System.currentTimeMillis();
        super.haveLunch();
        long l2 = System.currentTimeMillis();
        System.out.println("after [" + name + "]");
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
    }

    @Override
    public void haveSupper() {
        String name = "haveSupper";
        System.out.println("before [" + name + "]");
        long l1 = System.currentTimeMillis();
        super.haveSupper();
        long l2 = System.currentTimeMillis();
        System.out.println("after [" + name + "]");
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
    }

    @Override
    public void goToBed() {
        String name = "goToBed";
        System.out.println("before [" + name + "]");
        long l1 = System.currentTimeMillis();
        super.goToBed();
        long l2 = System.currentTimeMillis();
        System.out.println("after [" + name + "]");
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
    }

}
