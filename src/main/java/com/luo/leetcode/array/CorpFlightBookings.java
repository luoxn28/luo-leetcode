package com.luo.leetcode.array;

import java.util.Arrays;

/**
 * 航班预订统计
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 *
 * @author luoxiangnan
 * @date 2020-10-11
 */
public class CorpFlightBookings {

    public static void main(String[] args) {
        int[][] bookings = new int[3][];
        bookings[0] = new int[]{1, 2, 10};
        bookings[1] = new int[]{2, 3, 20};
        bookings[2] = new int[]{2, 5, 25};
        System.out.println(Arrays.toString(new CorpFlightBookings().corpFlightBookings(bookings, 5)));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        int[] diffs = difference(nums);

        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            addValue(diffs, i, j, booking[2]);
        }
        return recovery(diffs);
    }

    /**
     * 恢复原数组
     */
    private int[] recovery(int[] diffs) {
        int[] nums = new int[diffs.length];
        nums[0] = diffs[0];
        for (int i = 1; i < diffs.length; i++) {
            nums[i] = nums[i - 1] + diffs[i];
        }
        return nums;
    }

    /**
     * 给差分数组[i,j]区间+val
     */
    private void addValue(int[] diffs, int i, int j, int val) {
        diffs[i] += val;
        if (j < diffs.length - 1) {
            diffs[j + 1] -= val;
        }
    }

    /**
     * 生成差分数组
     */
    private int[] difference(int[] nums) {
        int[] diffs = new int[nums.length];
        diffs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diffs[i] = nums[i] - nums[i - 1];
        }
        return diffs;
    }
}
