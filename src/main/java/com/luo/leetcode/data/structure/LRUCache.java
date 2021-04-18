package com.luo.leetcode.data.structure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author luoxiangnan
 * @date 2021-04-18
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity = 0;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}