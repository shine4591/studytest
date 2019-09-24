package com.andy.factory.abstracts;

public class KFCResturantFactory implements IResturantFactory {
    @Override
    public IHamburge makeHamburge() {
        return new KFCHamburge();
    }

    @Override
    public IJuice makeJuice() {
        return new KFCJuice();
    }

    @Override
    public ISteak makeSteak() {
        return new KFCSteak();
    }
}
