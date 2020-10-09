package com.luo.leetcode.dp;

/**
 * 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author luoxiangnan
 * @date 2020-10-09
 */
public class Rob {

    public static void main(String[] args) {
        {
            int[] nums = new int[]{1, 2, 3, 1};
            System.out.println(new Rob().rob(nums));
        }

        {
            int[] nums = new int[]{2, 7, 9, 3, 1};
            System.out.println(new Rob().rob(nums));
        }

        {
            int[] nums = new int[]{2, 3, 2};
            System.out.println(new Rob().rob2(nums));
        }

        {
            int[] nums = new int[]{1, 2, 3, 1};
            System.out.println(new Rob().rob2(nums));
        }
    }

    /**
     * 房屋是环形
     */
    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return rob(nums, 0, nums.length - 1);
        }

        return Math.max(rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int dp_i_1 = 0, dp_i_2 = 0;
        int result = 0;

        for (int i = start; i <= end; i++) {
            result = Math.max(dp_i_2 + nums[i], dp_i_1);
            dp_i_2 = dp_i_1;
            dp_i_1 = result;
        }
        return result;
    }

    /**
     * 房屋是一排
     */
    public int rob(int[] nums) {
        int dp_i_1 = 0, dp_i_2 = 0;
        int result = 0;

        for (int num : nums) {
            result = Math.max(dp_i_2 + num, dp_i_1);
            dp_i_2 = dp_i_1;
            dp_i_1 = result;
        }
        return result;
    }
}
