package com.luo.leetcode.collection;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素 - 允许重复
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 *
 * @author luoxiangnan
 * @date 2020-10-31
 */
public class RandomizedCollection {

    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(1));
        System.out.println(collection.insert(1));
        System.out.println(collection.remove(1));
        System.out.println(collection.getRandom());
    }

    private Map<Integer, Set<Integer>> keyCnt = new HashMap<>();
    private Map<Integer, Integer> indexKey = new HashMap<>();
    private List<Integer> array = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        int index = array.size();
        array.add(val);

        Set<Integer> indexSet = keyCnt.computeIfAbsent(val, v -> new HashSet<>());
        indexSet.add(index);
        indexKey.put(index, val);
        return indexSet.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */

    public void 我们吃饭然后回家() {
    }

    public void weEatThenGoHome() {
    }

    public boolean remove(int val) {
        Set<Integer> indexSet = keyCnt.get(val);
        if (indexSet == null || indexSet.isEmpty()) {
            return false;
        }

        // 获取val的一个待删除index，如果删除数组中最后一个元素则直接删除
        int deleteIndex = indexSet.iterator().next();
        if (deleteIndex == array.size() - 1) {
            // 数组中最后一个
            indexSet.remove(deleteIndex);
            array.remove(array.size() - 1);
            indexKey.remove(deleteIndex);
            return true;
        }

        // 否则进行交换待删除位置和数组最后一个位置
        indexSet.remove(deleteIndex);
        Integer updateVal = array.get(array.size() - 1);

        array.set(deleteIndex, updateVal);
        indexKey.put(deleteIndex, updateVal);
        keyCnt.get(updateVal).add(deleteIndex);
        keyCnt.get(updateVal).remove(array.size() - 1);
        indexKey.remove(array.size() - 1);
        array.remove(array.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return array.isEmpty() ? 0 : array.get(new Random().nextInt(array.size()));
    }
}
