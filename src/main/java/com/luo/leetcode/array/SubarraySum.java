package com.luo.leetcode.array;

/**
 * @author luoxiangnan
 * @date 2021-04-07
 */
public class SubarraySum {

    public static void main(String[] args) {
        System.out.println(new SubarraySum().subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 数组前缀和
        int[] preSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSums[i + 1] = nums[i] + preSums[i];
        }

        int res = 0;
        for (int i = 0; i < preSums.length; i++) {
            for (int j = i + 1; j < preSums.length; j++) {
                if (preSums[j] - preSums[i] == k) {
                    res++;
                }
            }
        }

        return res;
    }
}
