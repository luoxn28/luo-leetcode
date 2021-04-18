package com.luo.leetcode.backtrack;

import java.util.Arrays;

/**
 * 排列序列
 * https://leetcode-cn.com/problems/permutation-sequence/
 *
 * @author luoxiangnan
 * @date 2021-04-16
 */
public class GetPermutation {

    public static void main(String[] args) {
        System.out.println(new GetPermutation().getPermutation(3, 3));
        System.out.println(new GetPermutation().getPermutation(4, 9));
        System.out.println(new GetPermutation().getPermutation(3, 1));
        System.out.println(new GetPermutation().getPermutation(3, 5));
        System.out.println(new GetPermutation().getPermutation(1, 1));
        System.out.println(new GetPermutation().getPermutation(4, 5));
    }

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, i);
            Arrays.sort(nums, 1, nums.length);
            doPermutation(nums, 1, k);

            // 复原
            Arrays.sort(nums);
        }

        return result;
    }

    private String result = "";
    private int curK = 0;

    public void doPermutation(int[] nums, int start, int k) {

        if (curK >= k) {
            return;
        } else if (start == nums.length - 1) {
            curK++;
            if (curK == k) {
                StringBuilder sb = new StringBuilder();
                Arrays.stream(nums).forEach(sb::append);
                result = sb.toString();
                return;
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 固定某个元素
            swap(nums, start, i);
            Arrays.sort(nums, start + 1, nums.length);

            doPermutation(nums, start + 1, k);
            // 复原
            Arrays.sort(nums, start, nums.length);
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
