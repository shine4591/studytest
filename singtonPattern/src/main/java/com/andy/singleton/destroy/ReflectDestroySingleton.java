package com.andy.singleton.destroy;

import com.andy.singleton.lazy.LazyDoubleCheckSingleton;

import java.lang.reflect.Constructor;

public class ReflectDestroySingleton {

    public static void main(String[] args) throws Exception {
//        Class<?> clazz = HungrySingleton.class;
//        Class<?> clazz = LazyInnerClassSingleton.class;
        Class<?> clazz = LazyDoubleCheckSingleton.class;
        Object instanceA = clazz.getDeclaredMethod("getInstance").invoke(null);
        System.out.println(instanceA);
        Constructor<?> c = clazz.getDeclaredConstructor();
        c.setAccessible(true);
        Object instanceB = c.newInstance();
        System.out.println(instanceB);
    }
}
