package com.andy.try3;

import com.andy.service.Service;
// 增加日志的代理
public class LoggerProxyService implements Service {
    private Service target;

    public LoggerProxyService(Service target) {
        this.target = target;
    }

    @Override
    public void getUp() {
        String name = "getUp";
        System.out.println("before [" + name + "]");
        target.getUp();
        System.out.println("after [" + name + "]");
    }

    @Override
    public void haveBreakfast() {
        String name = "haveBreakfast";
        System.out.println("before [" + name + "]");
        target.haveBreakfast();
        System.out.println("after [" + name + "]");
    }

    @Override
    public void haveLunch() {
        String name = "haveLunch";
        System.out.println("before [" + name + "]");
        target.haveLunch();
        System.out.println("after [" + name + "]");
    }

    @Override
    public void haveSupper() {
        String name = "haveSupper";
        System.out.println("before [" + name + "]");
        target.haveSupper();
        System.out.println("after [" + name + "]");
    }

    @Override
    public void goToBed() {
        String name = "goToBed";
        System.out.println("before [" + name + "]");
        target.goToBed();
        System.out.println("after [" + name + "]");
    }
}
