package com.luo.leetcode.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * @author luoxiangnan
 * @date 2020-10-10
 */
public class RegularIsMatch {

    public static void main(String[] args) {
        System.out.println(new RegularIsMatch().isMatch("aa", "a"));
        System.out.println(new RegularIsMatch().isMatch("aa", "a*"));
        System.out.println(new RegularIsMatch().isMatch("aa", ".*"));
        System.out.println(new RegularIsMatch().isMatch("aab", "c*a*b"));
        System.out.println(new RegularIsMatch().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new RegularIsMatch().isMatch("a", ""));
    }

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(String text, String pattern) {
        if (Objects.equals(text, pattern)) {
            return true;
        }

        dp(text, pattern, 0, 0);
        return memo.getOrDefault("0-0", false);
    }

    private boolean dp(String text, String pattern, int i, int j) {
        String key = i + "-" + j;
        if (memo.containsKey(key)) {
            memo.get(key);
        }

        if (j == pattern.length()) {
            return i == text.length();
        }

        boolean result;
        boolean first = i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');
        if (j <= pattern.length() - 2 && pattern.charAt(j + 1) == '*') {
            result = dp(text, pattern, i, j + 2) // 匹配0次
                    || (first && dp(text, pattern, i + 1, j)); // 匹配1次
        } else {
            result = first && dp(text, pattern, i + 1, j + 1);
        }
        memo.put(key, result);
        return result;
    }
}
