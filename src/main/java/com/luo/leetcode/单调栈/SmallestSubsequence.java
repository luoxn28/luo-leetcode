package com.luo.leetcode.单调栈;

import java.util.Stack;

/**
 * 不同字符的最小子序列
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * @author luoxiangnan
 * @date 2020-11-15
 */
public class SmallestSubsequence {

    public static void main(String[] args) {
        System.out.println(new SmallestSubsequence().smallestSubsequence("cdadabcc"));
        System.out.println(new SmallestSubsequence().smallestSubsequence("abcd"));
        System.out.println(new SmallestSubsequence().smallestSubsequence("ecbacba"));
        System.out.println(new SmallestSubsequence().smallestSubsequence("leetcode"));
    }

    /**
     * 调用栈思路：
     *
     * @see RemoveDuplicateLetters
     */
    public String smallestSubsequence(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        boolean[] visited = new boolean[256];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            count[c]--;
            if (visited[c]) {
                continue;
            }

            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek()] > 0) {
                visited[stack.pop()] = false;
            }

            visited[c] = true;
            stack.push(c);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
