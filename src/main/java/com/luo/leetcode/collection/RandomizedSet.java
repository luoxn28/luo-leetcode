package com.luo.leetcode.collection;

import java.util.*;

/**
 * 常数时间插入、删除和获取随机元素
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 *
 * @author luoxiangnan
 * @date 2020-10-02
 */
public class RandomizedSet {

    public static void main(String[] args) {
        {
            RandomizedSet randomizedSet = new RandomizedSet();

            System.out.println(randomizedSet.insert(0));
            System.out.println(randomizedSet.insert(1));
            System.out.println(randomizedSet.remove(0));
            System.out.println(randomizedSet.insert(2));
            System.out.println(randomizedSet.remove(1));
            System.out.println(randomizedSet.getRandom());
        }

        System.out.println();
        {
            RandomizedSet randomizedSet = new RandomizedSet();

            System.out.println(randomizedSet.insert(1));
            System.out.println(randomizedSet.remove(2));
            System.out.println(randomizedSet.insert(2));
            System.out.println(randomizedSet.getRandom());
            System.out.println(randomizedSet.remove(1));
            System.out.println(randomizedSet.insert(2));
            System.out.println(randomizedSet.getRandom());
        }
    }

    private List<Integer> array = new ArrayList<>();
    private Map<Integer, Integer> valIndex = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(Integer val) {
        if (valIndex.containsKey(val)) {
            return false;
        }

        valIndex.put(val, array.size());
        array.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(Integer val) {
        if (!valIndex.containsKey(val)) {
            return false;
        }

        swap(val, valIndex.get(val));
        array.remove(array.size() - 1);
        valIndex.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return array.get(new Random().nextInt(array.size()));
    }

    private void swap(int val, int index) {
        if (index == array.size() - 1) {
            return;
        }
        array.set(index, array.get(array.size() - 1));
        valIndex.put(array.get(array.size() - 1), index);

        array.set(array.size() - 1, val);
        valIndex.put(val, array.size() - 1);
    }
}
