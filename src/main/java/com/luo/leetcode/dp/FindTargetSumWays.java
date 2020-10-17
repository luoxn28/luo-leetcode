package com.luo.leetcode.dp;

/**
 * 目标和
 * https://leetcode-cn.com/problems/target-sum/
 *
 * @author luoxiangnan
 * @date 2020-10-16
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        {
            int[] nums = new int[]{1, 1, 1, 1, 1};
            System.out.println(new FindTargetSumWays().findTargetSumWays(nums, 3));
            System.out.println(new FindTargetSumWays().findTargetSumWays2(nums, 3));
        }

        {
            int[] nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1};
            System.out.println(new FindTargetSumWays().findTargetSumWays(nums, 1));
            System.out.println(new FindTargetSumWays().findTargetSumWays2(nums, 1));
        }
    }

    /**
     * 状态未压缩
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < S) {
            return 0;
        }

        sum += S;
        if (sum % 2 != 0) {
            return 0;
        }
        sum /= 2;


        int[][] dp = new int[nums.length + 1][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int w = 0; w <= sum; w++) {
                if (w - nums[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = dp[i - 1][w] + dp[i - 1][w - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    /**
     * 状态压缩
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum += S) % 2 == 1) {
            return 0;
        }

        sum /= 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int w = sum; w >= 0; w--) {
                if (w - nums[i - 1] < 0) {
                    continue;
                }

                dp[w] = dp[w] + dp[w - nums[i - 1]];
            }
        }
        return dp[sum];
    }
}
