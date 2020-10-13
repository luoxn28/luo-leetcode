package com.luo.leetcode.collection;


import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 滑动窗口中位数
 * https://leetcode-cn.com/problems/sliding-window-median/
 *
 * @author luoxiangnan
 * @date 2020-10-13
 */
public class MedianSlidingWindow {

    public static void main(String[] args) {
        {
            int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
            System.out.println(Arrays.toString(new MedianSlidingWindow().medianSlidingWindow(nums, 3)));
        }

        {
            int[] nums = new int[]{2147483647, 2147483647};
            System.out.println(Arrays.toString(new MedianSlidingWindow().medianSlidingWindow(nums, 2)));
        }

        {
            int[] nums = new int[]{-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648};
            System.out.println(Arrays.toString(new MedianSlidingWindow().medianSlidingWindow(nums, 2)));
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int left = 0, right = k - 1; right < nums.length; left++) {
            if (left < k - 1) {
                addValue(nums[left], left);
                continue;
            }

            addValue(nums[left], left);
            result[left - (k - 1)] = midValue();
            removeValue(left - (k - 1));
            right++;
        }

        return result;
    }

    private ArrayList<Pair> list = new ArrayList<>();

    private void addValue(int value, int index) {
        for (int i = 0; i < list.size(); i++) {
            if (value < list.get(i).value) {
                list.add(i, new Pair(value, index));
                return;
            }
        }
        list.add(new Pair(value, index));
    }

    private void removeValue(int index) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).index == index) {
                list.remove(i);
                return;
            }
        }
    }

    private double midValue() {
        if (list.size() % 2 == 1) {
            return list.get((list.size() - 1) / 2).value;
        } else {
            int mid = (list.size() - 1) / 2;
            return (double) ((long) list.get(mid).value + list.get(mid + 1).value) / 2;
        }
    }

    @ToString
    class Pair {
        public int value;
        public int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
