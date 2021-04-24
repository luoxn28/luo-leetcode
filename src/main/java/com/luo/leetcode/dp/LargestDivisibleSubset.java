package com.luo.leetcode.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 368. 最大整除子集
 * https://leetcode-cn.com/problems/largest-divisible-subset/
 *
 * @author luoxiangnan
 * @date 2021-04-23
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{5, 9, 18, 54, 90, 108, 540, 180, 360, 720}));
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{4, 8, 10, 240}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        // dp[i]表示元素i为结尾的最长有效子集个数
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxSize = 1, maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // 最后再反推出最长有效子集元素
        if (maxSize == 1) {
            return Arrays.asList(nums[0]);
        }

        int maxNum = nums[maxIndex];
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = maxIndex; i >= 0 && maxSize > 0; i--) {
            if ((maxNum % nums[i] == 0) && (dp[i] == maxSize)) {
                maxSize--;
                maxNum = nums[i];

                ans.addFirst(nums[i]);
            }
        }
        return ans;
    }

}
