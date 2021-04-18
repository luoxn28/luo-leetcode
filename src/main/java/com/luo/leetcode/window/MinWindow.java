package com.luo.leetcode.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author luoxiangnan
 * @date 2021-01-24
 */
public class MinWindow {

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinWindow().minWindow("a", "a"));
    }

    /**
     * 1. 构建滑动窗口[left, right)，right每往右移动一次，就将其添加到滑动窗口中
     * 2. 当滑动窗口中元素完全覆盖t时，开始缩减left
     * 3. 缩减left过程中进行判断，计算当前窗口长度和起止点，直到当前窗口不满足覆盖t为止
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int valid = 0; // 覆盖t个数，当达到t.length是表示完全覆盖
        int start = 0, len = Integer.MAX_VALUE; // 能覆盖t的最短字符串开始下标及长度
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if ((int) need.get(c) == window.get(c)) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    // 更新覆盖t的字符串下标和长度
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left); // 将要移除的元素
                left++;

                if (need.containsKey(d)) {
                    if ((int) need.get(d) == window.get(d)) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
