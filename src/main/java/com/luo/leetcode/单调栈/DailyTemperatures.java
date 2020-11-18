package com.luo.leetcode.单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author luoxiangnan
 * @date 2020-10-13
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        {
            int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
            System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(T)));
        }

        {
            int[] T = new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
            System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(T)));
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int[] nums = new int[T.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            nums[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return nums;
    }
}
