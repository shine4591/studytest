package com.andy.singleton.lazy;

public class LazyInnerClassSingleton {


    private LazyInnerClassSingleton() {
    }

    private static class LazySingletonHolder {
        private static LazyInnerClassSingleton lazy = new LazyInnerClassSingleton();
    }

    //利用类加载器保障线程安全
    //同时实现了懒加载
    public static LazyInnerClassSingleton getInstance() {
        return LazySingletonHolder.lazy;
    }

}
