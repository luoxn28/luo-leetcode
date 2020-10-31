package com.luo.leetcode.array;

/**
 * @author luoxiangnan
 * @date 2020-10-31
 */
public class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = (i == 0 ? nums[i] : sums[i - 1] + nums[i]);
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }
}
