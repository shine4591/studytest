package com.andy.myredis.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUmap extends LinkedHashMap {
    private int maxElements;

    public LRUmap(int size) {
        super(size);
        maxElements = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxElements;
    }
}
