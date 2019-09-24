package com.andy.factory.method;

import com.andy.factory.IResturant;
import com.andy.factory.KFCResturant;

public class KFCResturantFactory implements IResturantFactory {
    @Override
    public IResturant createResturant() {
        return new KFCResturant();
    }
}
