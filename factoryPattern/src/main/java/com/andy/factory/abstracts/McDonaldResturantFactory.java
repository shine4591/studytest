package com.andy.factory.abstracts;

public class McDonaldResturantFactory implements IResturantFactory {
    @Override
    public IHamburge makeHamburge() {
        return new McDonaldHamburge();
    }

    @Override
    public IJuice makeJuice() {
        return new McDonaldJuice();
    }

    @Override
    public ISteak makeSteak() {
        return new McDonaldSteak();
    }
}
