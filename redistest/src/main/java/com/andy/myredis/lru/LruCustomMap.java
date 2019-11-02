package com.andy.myredis.lru;

import java.util.HashMap;

public class LruCustomMap {
    private int maxSize;

    private class DataHolder {
        private Object key;
        private Object val;
        private DataHolder prev;
        private DataHolder next;

        private DataHolder(Object key, Object val) {
            this.key = key;
            this.val = val;
        }
    }
    // head ...................................................tail(从尾部删)
    //[pre=null Node next] [pre Node next] [pre Node next] ..... [pre Node next=null]

    private int size = 0;
    private DataHolder head = null;
    private DataHolder tail = null;

    private HashMap<Object, DataHolder> map = new HashMap<>();// HashMap辅助快速查找，tail/head 做LRU

    public LruCustomMap(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(Object key, Object val) {
        if (!map.containsKey(key)) {
            DataHolder dh = new DataHolder(key, val);
            if (size == 0) {
                head = dh;
                tail = dh;
                map.put(key, dh);
                size++;
            } else {
                dh.next = head;//新节点，放到头部
                head.prev = dh;
                head = dh;
                map.put(key, dh);
                if (size < maxSize) {
                    size++;
                } else {//删除最后一个节点
                    map.remove(tail.key);
                    DataHolder newtail = tail.prev;
                    if (newtail != null) {
                        newtail.next = null;
                        tail.prev = null;
                        tail = newtail;
                    } else {//size == 1 ??? 太小了，可以不考虑
                        tail = dh;
                    }
                }
            }
        } else {//替换
            DataHolder dh = map.get(key);
            dh.val = val;
            moveToHead(dh);
        }
    }

    private void moveToHead(DataHolder dh) {
        DataHolder prev = dh.prev;
        DataHolder next = dh.next;
        if (prev != null) {
            prev.next = next;
        } else {
            assertTrue(dh == head);// 一定是head， 不用动
            return;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            assertTrue(dh == tail);
            tail = prev;
            tail.next = null;
        }
        dh.prev = null;
        dh.next = head;
        head.prev = dh;
        head = dh;
    }

    private void assertTrue(boolean flag) {
        if (!flag) {
            throw new RuntimeException("bug");
        }
    }

    public Object get(Object key) {
        DataHolder dh = map.get(key);
        moveToHead(dh);
        return dh.val;
    }

    public Object remove(Object key) {
        if (!map.containsKey(key)) {
            return null;
        }
        size--;
        DataHolder dh = map.remove(key);
        DataHolder prev = dh.prev;
        DataHolder next = dh.next;
        if (prev != null) {
            prev.next = next;
        } else {
            assertTrue(dh == head);// 一定是head
            head.next = null;
            head = next;
        }

        if (next != null) {
            next.prev = prev;
        } else {
            assertTrue(dh == tail);
            dh.prev = null;
            tail = prev;
        }
        return dh.val;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("size: " + size);
        DataHolder pointer = head;
        sb.append("{");
        while (pointer != null) {
            Object prevKey = (pointer.prev == null ? "null" : pointer.prev.key + "<-");
            sb.append("   [").append(prevKey).append("]");
            sb.append("[").append(pointer.key).append(",").append(pointer.val).append("]");
            Object nextKey = (pointer.next == null ? "null" : "->" + pointer.next.key);
            sb.append("[").append(nextKey).append("]");
            pointer = pointer.next;
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        LruCustomMap lcm = new LruCustomMap(5);
        lcm.put("1", "11");
        System.out.println(lcm);
        lcm.put("2", "22");
        System.out.println(lcm);
        lcm.put("3", "33");
        System.out.println(lcm);
        lcm.put("4", "44");
        System.out.println(lcm);
        lcm.put("5", "55");
        System.out.println(lcm);
        lcm.put("6", "66");
        System.out.println(lcm);
        lcm.put("4", "4n");
        System.out.println(lcm);
        lcm.put("2", "2n");
        System.out.println(lcm);
        System.out.println(lcm.get("3"));
        System.out.println(lcm);
        System.out.println(lcm.get("4"));
        System.out.println(lcm);
        lcm.remove("4");
        System.out.println(lcm);
        lcm.remove("2");
        System.out.println(lcm);
        lcm.remove("5");
        System.out.println(lcm);
        lcm.remove("3");
        System.out.println(lcm);
        lcm.remove("6");
        System.out.println(lcm);
        lcm.remove("6");
        System.out.println(lcm);

    }
}
