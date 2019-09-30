package com.andy.singleton.lazy;

/**
 *
 */
public class PreventReflectSingleton {
    private PreventReflectSingleton() {
        if(LazySingletonHolder.lock != null){
            throw new RuntimeException("try to reflect??? no way.....");
        }
    }

    private static class LazySingletonHolder {
        private static final PreventReflectSingleton lazy = new PreventReflectSingleton();
        private static final Object lock = new Object();
    }

    //利用类加载器保障线程安全
    //同时实现了懒加载
    public static PreventReflectSingleton getInstance() {
        return LazySingletonHolder.lazy;
    }

}
