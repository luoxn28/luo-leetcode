package com.luo.leetcode.dp;

/**
 * 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author luoxiangnan
 * @date 2020-10-31
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()()))()"));
    }

    public int longestValidParentheses(String s) {
        int[] left = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }

            int j = i - 1;
            for (; j >= 0 && left[j] != -1; j--) {
                if (s.charAt(j) == '(' && left[j] == 0) {
                    left[j] = 1;
                    left[i] = 1;
                    break;
                }
            }

            if (j < 0 || left[j] != 1) {
                left[i] = -1;
            }
        }

        int max = 0, curSum = 0;
        for (int i = 0; i < left.length; i++) {
            if (left[i] != 1) {
                curSum = 0;
            } else {
                curSum += 1;
            }

            max = Math.max(max, curSum);
        }
        return max;
    }
}
