package com.luo.leetcode.dp;

/**
 * @author luoxiangnan
 * @date 2020-10-31
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -9, -6};
        System.out.println(new MaxProduct().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dpMin[i] = nums[i];
                dpMax[i] = nums[i];
                max = nums[i];
            } else {
                dpMin[i] = Math.min(Math.min(nums[i], dpMin[i - 1] * nums[i]),
                        dpMax[i - 1] * nums[i]);
                dpMax[i] = Math.max(Math.max(nums[i], dpMax[i - 1] * nums[i]),
                        dpMin[i - 1] * nums[i]);
                max = Math.max(max, dpMax[i]);
            }
        }
        return max;
    }
}
