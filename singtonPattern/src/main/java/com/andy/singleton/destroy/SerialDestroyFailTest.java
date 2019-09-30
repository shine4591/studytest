package com.andy.singleton.destroy;

import com.andy.singleton.serial.SerializableRealSingleton;
import com.andy.singleton.serial.SerializableSingleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//序列化破坏单例失败示例
public class SerialDestroyFailTest {

    public static void main(String[] args) throws Exception {
        Object instanceA = SerializableRealSingleton.getInstance();
        System.out.println(instanceA);
        byte[] bs;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream ops = new ObjectOutputStream(bos);) {
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
