package com.luo.leetcode.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 黑名单中的随机数
 * https://leetcode-cn.com/problems/random-pick-with-blacklist/
 *
 * @author luoxiangnan
 * @date 2020-10-02
 */
public class RandomizedSetBlackList {

    public static void main(String[] args) {
        RandomizedSetBlackList randomizedSet = new RandomizedSetBlackList(2, new int[]{1});
        System.out.println(randomizedSet.pick());
        System.out.println(randomizedSet.pick());
        System.out.println(randomizedSet.pick());
        System.out.println(randomizedSet.pick());
        System.out.println(randomizedSet.pick());
    }

    public RandomizedSetBlackList(int N, int[] blacklist) {

        // 找出所有小于N的黑名单
        for (int val : blacklist) {
            if (val < N) {
                // 临时设置-1
                valIndex.put(val, -1);
            }
        }

        // size表示随机选择的最大范围
        size = N - valIndex.size();

        // 将小于size的黑名单中数据替换为对应的 size-N之间的非白名单数据
        int last = N - 1;
        for (int val : blacklist) {
            if (val < size) {
                while (valIndex.containsKey(last)) {
                    last--;
                }

                valIndex.put(val, last);
                last--;
            }
        }
    }

    private int size;
    private Map<Integer, Integer> valIndex = new HashMap<>();

    public int pick() {
        int val = new Random().nextInt(size);
        return valIndex.getOrDefault(val, val);
    }
}
