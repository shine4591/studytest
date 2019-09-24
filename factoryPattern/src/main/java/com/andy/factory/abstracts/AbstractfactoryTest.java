package com.andy.factory.abstracts;

public class AbstractfactoryTest {

    public static void main(String[] args) {
        IResturantFactory factory = new KFCResturantFactory();
        factory.makeHamburge().checkHowBig();
        factory.makeJuice().checkHowDrink();

    }

}
