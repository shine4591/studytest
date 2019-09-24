package com.andy.factory.simple;

import com.andy.factory.IResturant;

public class ResturantFactory {

    public IResturant createInstance(Class<? extends IResturant> c) {
        try {
            return c.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
