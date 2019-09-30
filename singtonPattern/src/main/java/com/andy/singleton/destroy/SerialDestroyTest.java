package com.andy.singleton.destroy;

import com.andy.singleton.lazy.LazyDoubleCheckSingleton;
import com.andy.singleton.serial.SerializableSingleton;

import java.io.*;
import java.lang.reflect.Constructor;

//序列化破坏单例示例
public class SerialDestroyTest {

    public static void main(String[] args) throws Exception {
        Object instanceA = SerializableSingleton.getInstance();
        System.out.println(instanceA);
        byte[] bs;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream ops = new ObjectOutputStream(bos);
        ) {
            ops.writeObject(instanceA);
            ops.flush();
            bs = bos.toByteArray();
        }
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bs);
             ObjectInputStream ois = new ObjectInputStream(bis);
        ) {
            Object instanceB = ois.readObject();
            System.out.println(instanceB);
        }

    }
}
