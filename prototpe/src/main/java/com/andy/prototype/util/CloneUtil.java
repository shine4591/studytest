package com.andy.prototype.util;

import java.io.*;

public class CloneUtil {

    public static <T> T deepClone(T obj) throws Exception {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos);) {
            oos.writeObject(obj);
            oos.flush();
            byte[] bs = bos.toByteArray();
            try (ByteArrayInputStream bis = new ByteArrayInputStream(bs);
                 ObjectInputStream ois = new ObjectInputStream(bis);) {
                return (T) ois.readObject();
            }
        }
    }
}
