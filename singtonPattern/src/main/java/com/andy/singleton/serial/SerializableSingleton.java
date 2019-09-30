package com.andy.singleton.serial;


import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    private volatile static SerializableSingleton lazy;

    private SerializableSingleton() {

    }

    public static synchronized SerializableSingleton getInstance() {
        if (lazy == null) {
            lazy = new SerializableSingleton();
        }
        return lazy;
    }

}
