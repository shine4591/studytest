package com.andy.singleton.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {
    private ContainerSingleton() {
    }

    private static Map<String, Object> container = new ConcurrentHashMap<>();

    public static Object getInstance(String className) {
        synchronized (container) {
            if (!container.containsKey(className)) {
                return container.get(className);
            }
            Object obj = null;
            try {
                obj = Class.forName(className).newInstance();
                container.put(className, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;
        }
    }

}
