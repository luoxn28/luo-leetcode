package com.luo.leetcode.单调栈;

import java.util.Stack;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author luoxiangnan
 * @date 2020-11-17
 */
public class TrapRainWasterI {

    public static void main(String[] args) {
        System.out.println(new TrapRainWasterI().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new TrapRainWasterI().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    /**
     * 单调栈
     * 1. 维护一个非递减增调栈；
     * 2. 如果当前元素大于栈顶元素，那么就从栈中弹出并计算弹出元素对应的可存水量;
     * 可存水量计算公式 长*高：index = stack.pop(); 然后 (i - stack.peek() - 1) * (min(height[i], height[stack.peek()]) - height[index])
     */
    public int trap(int[] height) {
        Stack<Integer> indexStack = new Stack<>();

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!indexStack.isEmpty() && height[i] > height[indexStack.peek()]) {
                int index = indexStack.pop();
                if (!indexStack.isEmpty()) {
                    // 长*宽
                    res += (i - indexStack.peek() - 1) *
                            (Math.min(height[i], height[indexStack.peek()]) - height[index]);
                }
            }

            indexStack.push(i);
        }
        return res;
    }
}
