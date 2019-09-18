package com.andy.service.impl;

import com.andy.service.Service;
import java.util.Random;

public class ServiceImpl implements Service {
    @Override
    public void getUp() {
        System.out.println("I am getting up");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void haveBreakfast() {
        System.out.println("I am having my breakfast");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void haveLunch() {
        System.out.println("I am having my lunch");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void haveSupper() {
        System.out.println("I am having my supper");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goToBed() {
        System.out.println("I am going to bed");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
