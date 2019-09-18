package com.andy.try5;

import com.andy.service.Service;
import com.andy.service.impl.ServiceImpl;
import com.andy.try5.handler.LoggerInvoker;
import com.andy.try5.handler.TimeInvoker;

import java.util.ArrayList;
import java.util.List;

public class DynamicProxyTest {

    public static void main(String[] args) throws Exception {
        LoggerInvoker logger = new LoggerInvoker();// 额外逻辑实例可以是依赖注入得到的
        TimeInvoker timer = new TimeInvoker();

        //给List套个代理看看
        Class<?> clazz = List.class;
        List<Object> list = new ArrayList<>(); // list实例可以是依赖注入得到的
        list = (List<Object>) ProxyGenerator.getProxy(clazz, list, logger, timer);
        list.add("1");
        System.out.println(list.size());

        System.out.println("start service proxy call done...");
        //给Service套个代理看看
        Service s = new ServiceImpl();
        s = ProxyGenerator.getProxy(Service.class, s, logger, timer);
        System.out.println(s.getClass().getName());
        s.getUp();
        s.haveBreakfast();
        s.haveLunch();
        s.haveSupper();
        s.goToBed();
        System.out.println("dynamic proxy call done...");
    }

}
