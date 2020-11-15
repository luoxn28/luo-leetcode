package com.luo.leetcode.单调栈;

import java.util.Stack;

/**
 * 去除重复字母
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 使用单调栈来解决
 *
 * @author luoxiangnan
 * @date 2020-09-30
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("bcabc"));
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("bbcaac"));
    }

    /**
     * 单调栈思路，栈内元素按照字典序。
     * 按照字典序排序，也就说是遍历字符串，如果当前字符cur小于上一个字符prev并且后面还有字符prev，那么就将cur保留，将prev丢弃，以满足字典序最小。
     * 如果当前字符cur大于上一个字符，那么直接push到栈中。
     * 如果当前字符cur和上一个字符相等，那么如果当前cur是相同字符的最后一个，那么需要保留，否则移除上一个字符。
     */
    public String removeDuplicateLetters(String s) {
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

            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek()] > 0) {
                visited[stack.pop()] = false;
            }

            visited[c] = true;
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
