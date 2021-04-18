package com.luo.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author luoxiangnan
 * @date 2021-04-10
 */
public class Merge {

    public static void main(String[] args) {
        System.out.println(new Merge().candy(new int[]{1, 0, 2}));
        System.out.println(new Merge().candy(new int[]{1, 2, 2}));
    }

    public int candy(int[] ratings) {
        // 比相邻孩子多的糖果数组
        int[] moreNums = new int[ratings.length];

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                moreNums[i] = moreNums[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                moreNums[i] = Math.max(moreNums[i], moreNums[i + 1] + 1);
            }
        }

        System.out.println(Arrays.toString(moreNums));

        int sum = ratings.length;
        for (int num : moreNums) {
            sum += num;
        }
        return sum;
    }

    public void maxBeforeMin(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
                max = Math.max(max, nums[i + 1]);
            }
        }
        System.out.println(max + " " + min);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // 合并后区间开始下标
        int start = 0;
        int[][] result = new int[intervals.length][2];
        result[0] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result[start][1]) {
                result[start][1] = Math.max(result[start][1], intervals[i][1]);
            } else {
                result[++start] = intervals[i];
            }
        }

        return Arrays.copyOf(result, start + 1);
    }
}
