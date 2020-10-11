package com.luo.leetcode.dp;

import java.util.Arrays;

/**
 * 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author luoxiangnan
 * @date 2020-10-10
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        {
            int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
            System.out.println(new LengthOfLIS().lengthOfLIS(nums));
        }

        {
            int[] nums = new int[]{1, 3, 5, 4, 7};
            System.out.println(new LengthOfLIS().findLengthOfLCIS(nums));
        }

        {
            int[] nums = new int[]{2, 2, 2, 2, 2};
            System.out.println(new LengthOfLIS().findLengthOfLCIS(nums));
        }
    }

    /**
     * 最长连续子序列
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int num : dp) {
            max = Math.max(max, num);
        }
        return max;
    }

    /**
     * 最长连续子串
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        int max = 0;
        for (int num : dp) {
            max = Math.max(max, num);
        }
        return max;
    }

}
