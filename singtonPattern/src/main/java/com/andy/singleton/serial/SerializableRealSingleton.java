package com.andy.singleton.serial;


import java.io.Serializable;

public class SerializableRealSingleton implements Serializable {

    private volatile static SerializableRealSingleton lazy;

    private SerializableRealSingleton() {

    }
    //方法上加了锁，效率不高
    public static synchronized SerializableRealSingleton getInstance() {
        if (lazy == null) {
            lazy = new SerializableRealSingleton();
        }
        return lazy;
    }

    private Object readResolve(){
        return  lazy;
    }

}
