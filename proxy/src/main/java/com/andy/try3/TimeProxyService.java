package com.andy.try3;

import com.andy.service.Service;

// 增加计时的代理
public class TimeProxyService implements Service {
    private Service target;

    public TimeProxyService(Service target) {
        this.target = target;
    }

    @Override
    public void getUp() {
        String name = "getUp";
        long l1 = System.currentTimeMillis();
        target.getUp();
        long l2 = System.currentTimeMillis();
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
    }

    @Override
    public void haveBreakfast() {
        String name = "haveBreakfast";
        long l1 = System.currentTimeMillis();
        target.haveBreakfast();
        long l2 = System.currentTimeMillis();
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
    }

    @Override
    public void haveLunch() {
        String name = "haveLunch";
        long l1 = System.currentTimeMillis();
        target.haveLunch();
        long l2 = System.currentTimeMillis();
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
    }

    @Override
    public void haveSupper() {
        String name = "haveSupper";
        long l1 = System.currentTimeMillis();
        target.haveSupper();
        long l2 = System.currentTimeMillis();
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
    }

    @Override
    public void goToBed() {
        String name = "goToBed";
        long l1 = System.currentTimeMillis();
        target.goToBed();
        long l2 = System.currentTimeMillis();
        System.out.println("[" + name + "] takes " + (l2 - l1) + " ms");
    }
}
