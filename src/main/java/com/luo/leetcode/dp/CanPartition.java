package com.luo.leetcode.dp;

/**
 * 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @author luoxiangnan
 * @date 2020-10-10
 */
public class CanPartition {

    public static void main(String[] args) {
        {
            int[] nums = new int[]{1, 5, 11, 5};
            System.out.println(new CanPartition().canPartition(nums));
        }
        {
            int[] nums = new int[]{1, 2, 3, 5};
            System.out.println(new CanPartition().canPartition(nums));
        }
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean dp[][] = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int w = 1; w <= target; w++) {
                if (w - nums[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = dp[i - 1][w] // 不装
                            || dp[i - 1][w - nums[i - 1]]; // 装
                }
            }
        }

        return dp[nums.length][target];
    }
}
