package com.luo.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author luoxiangnan
 * @date 2020-10-07
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> visited = new HashSet<>();
        int left = 0, right = 0;

        int longest = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            while (visited.contains(c)) {
                char d = s.charAt(left);
                left++;
                visited.remove(d);
            }

            visited.add(c);
            longest = Math.max(longest, visited.size());
        }
        return longest;
    }
}
