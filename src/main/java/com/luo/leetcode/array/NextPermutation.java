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
            int[] nums = new int[]{1, 1};
            new NextPermutation().nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }

    public void nextPermutation2(int[] nums) {
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

    public void nextPermutation(int[] nums) {
        // 逆序找到第一个 小于其右侧的元素n
        int left = nums.length - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }
        // 未找到翻转整个数组
        if (left == -1) {
            reverse(nums, 0);
            return;
        }

        // 逆序找到第一个大于元素n的元素
        int right = nums.length - 1;
        while (right >= 0 && nums[right] <= nums[left]) {
            right--;
        }

        swap(nums, left, right);
        reverse(nums, left + 1);
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
