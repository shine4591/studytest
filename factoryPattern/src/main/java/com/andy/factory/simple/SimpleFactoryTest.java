package com.andy.factory.simple;

import com.andy.factory.IResturant;
import com.andy.factory.KFCResturant;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        ResturantFactory factory = new ResturantFactory();
        IResturant resturant = factory.createInstance(KFCResturant.class);
        resturant.makeHamburger();
    }

}
