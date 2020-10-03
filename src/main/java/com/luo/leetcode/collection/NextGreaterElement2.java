package com.luo.leetcode.collection;

import java.util.Arrays;
import java.util.Stack;

/**
 * 下一个更大元素 II
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 *
 * @author luoxiangnan
 * @date 2020-10-03
 */
public class NextGreaterElement2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        System.out.println(Arrays.toString(new NextGreaterElement2().nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] nums2 = new int[2 * nums.length];

        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums2[i + nums.length] = nums[i];
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            int res = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);

            if (i < nums.length) {
                nums[i] = res;
            }
        }
        return nums;
    }
}
