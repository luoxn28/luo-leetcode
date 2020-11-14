package com.luo.leetcode.array;

import java.util.Arrays;

/**
 * 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @author luoxiangnan
 * @date 2020-11-10
 */
public class NextPermutation {

    public static void main(String[] args) {
        {
            int[] nums = new int[]{1, 2, 3};
            new NextPermutation().nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
        {
            int[] nums = new int[]{3, 2, 1};
            new NextPermutation().nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
        {
            int[] nums = new int[]{1, 1, 5};
            new NextPermutation().nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
        {
            int[] nums = new int[]{2, 3, 1};
            new NextPermutation().nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
