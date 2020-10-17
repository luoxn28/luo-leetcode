package com.luo.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长回文串
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * @author luoxiangnan
 * @date 2020-10-15
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        int size = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
                size += 2;
            }
        }
        return set.isEmpty() ? size : size + 1;
    }
}
