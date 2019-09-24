package com.andy.factory.method;

import com.andy.factory.IResturant;

public class FactoryMethodTest {

    public static void main(String[] args) {
        IResturantFactory factory = new KFCResturantFactory();
        IResturant resturant = factory.createResturant();
        resturant.makeHamburger();

        factory = new McDonaldResturantFactory();
        resturant = factory.createResturant();
        resturant.makeHamburger();
    }
}
