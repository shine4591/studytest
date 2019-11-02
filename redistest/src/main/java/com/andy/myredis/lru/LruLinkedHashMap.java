package com.andy.myredis.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 偷懒写法
 */
public class LruLinkedHashMap extends LinkedHashMap {
    private int maxElements;

    public LruLinkedHashMap(int size) {
        super(size);
        maxElements = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxElements;
    }
}
