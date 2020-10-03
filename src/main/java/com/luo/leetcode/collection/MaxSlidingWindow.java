package com.luo.leetcode.collection;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 1. 构建一个单调队列，只保留较大的值（将队列小于待加入的元素的所有小值都丢弃）
 * 2. 遍历数组，构建初始滑动窗口对应的单调队列。继续遍历，维护单调队列并且获取单调队列中最大值(左值)，然后将单调队列中等于该遍历元素的最左侧值移除
 *
 * @author luoxiangnan
 * @date 2020-10-03
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(nums, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 填充滑动窗口
                push(nums[i]);
                continue;
            }

            push(nums[i]);
            result[i - k + 1] = max();
            pop(nums[i - k + 1]);
        }
        return result;
    }

    Deque<Integer> deque = new ArrayDeque<>();

    void push(int n) {
        while (!deque.isEmpty() && deque.getLast() < n) {
            deque.removeLast();
        }
        deque.addLast(n);
    }

    void pop(int n) {
        if (!deque.isEmpty() && deque.getFirst() == n) {
            deque.removeFirst();
        }
    }

    int max() {
        return deque.getFirst();
    }
}
