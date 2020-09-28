package com.luo.leetcode.search;

import org.junit.Assert;

/**
 * 二分查找
 *
 * @author luoxiangnan
 * @date 2020-09-28
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        Assert.assertEquals(binarySearch(nums, 1), 1);
        Assert.assertEquals(binarySearch(nums, 5), 5);
        Assert.assertEquals(binarySearch(nums, 10), -1);

        nums = new int[]{1, 1, 1, 3, 4, 5, 6, 6, 6};
        Assert.assertEquals(leftBinarySearch(nums, 1), 0);
        Assert.assertEquals(leftBinarySearch(nums, 6), 6);
        Assert.assertEquals(leftBinarySearch(nums, 10), -1);
        Assert.assertEquals(leftBinarySearch(nums, -10), -1);

        Assert.assertEquals(rightBinarySearch(nums, 1), 2);
        Assert.assertEquals(rightBinarySearch(nums, 6), 8);
        Assert.assertEquals(rightBinarySearch(nums, 10), -1);
        Assert.assertEquals(rightBinarySearch(nums, -10), -1);
    }

    /**
     * 经典二分查找
     */
    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 左侧边界值二分查找
     */
    private static int leftBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 右侧边界值二分查找
     */
    private static int rightBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
