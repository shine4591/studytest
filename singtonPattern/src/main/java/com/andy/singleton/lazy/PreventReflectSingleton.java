package com.andy.singleton.lazy;

/**
 *
 * 内部类单例防反射示例
 *
 * 内部类保证懒加载
 * 类加载器保证线程安全
 *
 * 加载顺序保证了 正常调用与反射破坏 无论谁先谁后，反射都会失败
 *
 */
public class PreventReflectSingleton {
    static{
        System.out.println("in static ....");
    }
    private PreventReflectSingleton(String fromWhere) {
        if(LazySingletonHolder.lazy != null){
            System.out.println("from...." + fromWhere + " init failed");
            throw new RuntimeException("try to reflect??? no way.....");
        }
        System.out.println("from...." + fromWhere + " init successfully");
    }

    private static class LazySingletonHolder {
        static{
            System.out.println("before holder init ....");
        }
        private static final PreventReflectSingleton lazy = new PreventReflectSingleton("lazyHolder");

    }

    //利用类加载器保障线程安全
    //同时实现了懒加载
    public static PreventReflectSingleton getInstance() {
        return LazySingletonHolder.lazy;
    }

}
