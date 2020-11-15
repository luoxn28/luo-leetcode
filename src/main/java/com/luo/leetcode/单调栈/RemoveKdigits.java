package com.luo.leetcode.单调栈;


import java.util.ArrayDeque;

/**
 * 移掉K位数字
 * https://leetcode-cn.com/problems/remove-k-digits/
 *
 * @author luoxiangnan
 * @date 2020-11-15
 */
public class RemoveKdigits {

    public static void main(String[] args) {
        System.out.println(new RemoveKdigits().removeKdigits("4321", 2));
        System.out.println(new RemoveKdigits().removeKdigits("10200", 1));
        System.out.println(new RemoveKdigits().removeKdigits("110", 2));
        System.out.println(new RemoveKdigits().removeKdigits("11100", 3));
        System.out.println(new RemoveKdigits().removeKdigits("111", 0));
    }

    /**
     * 使用单调栈
     */
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.getLast()) {
                stack.pollLast();
                k--;
            }

            stack.add(num.charAt(i));
        }

        while (!stack.isEmpty() && stack.getFirst() == '0') {
            stack.pollFirst();
        }

        int length = stack.size() - k;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(stack.pollFirst());
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
