package com.luo.leetcode.dp;

/**
 * 组合总和 Ⅳ
 * https://leetcode-cn.com/problems/combination-sum-iv/
 *
 * @author luoxiangnan
 * @date 2020-10-24
 */
public class CombinationSum4 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new CombinationSum4().combinationSum4(nums, 4));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (num < nums[i]) {
                    cnt++;
                }
            }
            dp[i] = cnt;
        }
        return dp;
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
