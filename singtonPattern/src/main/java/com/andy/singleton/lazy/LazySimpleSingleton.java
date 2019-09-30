package com.andy.singleton.lazy;

public class LazySimpleSingleton {

    private volatile static LazySimpleSingleton lazy;

    private LazySimpleSingleton() {

    }
    //方法上加了锁，效率不高
    public static synchronized LazySimpleSingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }

}
