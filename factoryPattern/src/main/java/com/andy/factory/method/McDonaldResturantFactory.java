package com.andy.factory.method;

import com.andy.factory.IResturant;
import com.andy.factory.McDonaldResturant;

public class McDonaldResturantFactory implements IResturantFactory {
    @Override
    public IResturant createResturant() {
        return new McDonaldResturant();
    }
}
