package com.luo.leetcode.data.structure;

import java.util.*;

/**
 * 432. 全 O(1) 的数据结构
 * https://leetcode-cn.com/problems/all-oone-data-structure/
 *
 * @author luoxiangnan
 * @date 2021-04-18
 */
public class AllOne {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();

        /**
         * ["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","getMinKey"]
         * [[],      ["a"],["b"],["c"],["d"],["a"],["b"],["c"],["d"],["c"],["d"],["d"],["a"],[]]
         */

        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("d");
        allOne.inc("a");

        System.out.println(allOne.getMinKey());
    }

    private Map<String, Integer> kvMap = new HashMap<>();
    private TreeMap<Integer, Set<String>> vkMap = new TreeMap<>();

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        int value = kvMap.getOrDefault(key, 0) + 1;
        kvMap.put(key, value);

        if (value > 1) {
            removeVk(value - 1, key);
        }
        vkMap.computeIfAbsent(value, o -> new HashSet<>()).add(key);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        Integer value = kvMap.get(key);
        if (value == null) {
            return;
        }

        if (value == 1) {
            kvMap.remove(key);
            removeVk(value, key);
        } else {
            kvMap.put(key, value - 1);

            removeVk(value, key);
            vkMap.computeIfAbsent(value - 1, o -> new HashSet<>()).add(key);
        }
    }

    private void removeVk(Integer value, String key) {
        Set<String> keys = vkMap.get(value);
        if (keys == null) {
            return;
        }

        keys.remove(key);
        if (keys.isEmpty()) {
            vkMap.remove(value);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        Map.Entry<Integer, Set<String>> entry = vkMap.lastEntry();
        return entry == null ? "" : entry.getValue().iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        Map.Entry<Integer, Set<String>> entry = vkMap.firstEntry();
        return entry == null ? "" : entry.getValue().iterator().next();
    }
}
