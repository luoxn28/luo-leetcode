package com.luo.leetcode.单调栈;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author luoxiangnan
 * @date 2020-11-18
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 11}));
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{2, 1, 2}));
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{1, 1}));
    }

    /**
     * 基于栈结构解题思路
     * 1. 遍历数组heights，维护一个单调非递减栈stack(存下标)，如果当前元素(下标为i)小于栈顶元素，那么弹出栈顶元素stack.pop()=a
     * 2. 如果此时栈非空，那么计算包含该栈顶元素heights[a]的矩形面积：长*宽 = heights[a] * (i-stack.peek()-1)
     * 3. 如果此时栈为空，那么此时包含栈顶元素heights[a]的矩形面积就是: height[a]
     * 4. 遍历完成之后，如果栈非空，此时遍历的右侧下表为i(此次可假设i下表对应高度为0)，继续弹出栈，计算对应元素面积
     * 5. 弹出栈过程中，维护最大的面积作为最后返回结果
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        } else if (heights.length == 1) {
            return heights[0];
        }

        Stack<Integer> stack = new Stack<>();

        int left = -1; // 最左侧标兵下标，方便计算
        int res = 0, i = 0;
        for (; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int a = stack.pop();
                if (!stack.isEmpty()) {
                    res = Math.max(res, (i - stack.peek() - 1) * heights[a]);
                } else {
                    res = Math.max(res, (i - left - 1) * heights[a]);
                }
            }

            if (heights[i] == 0) {
                left = i;
            } else {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int a = stack.pop();
            if (!stack.isEmpty()) {
                res = Math.max(res, (i - stack.peek() - 1) * heights[a]);
            } else {
                res = Math.max(res, (i - left - 1) * heights[a]);
            }
        }

        return res;
    }
}
