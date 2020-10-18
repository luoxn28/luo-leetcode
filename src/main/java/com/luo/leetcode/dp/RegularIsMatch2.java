package com.luo.leetcode.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 通配符匹配
 * https://leetcode-cn.com/problems/wildcard-matching/
 *
 * @author luoxiangnan
 * @date 2020-10-18
 */
public class RegularIsMatch2 {

    public static void main(String[] args) {
        System.out.println(new RegularIsMatch2().isMatch("aa", "a"));
        System.out.println(new RegularIsMatch2().isMatch("aa", "*"));
        System.out.println(new RegularIsMatch2().isMatch("cb", "?a"));
        System.out.println(new RegularIsMatch2().isMatch("adceb", "*a*b"));
        System.out.println(new RegularIsMatch2().isMatch("acdcb", "a*c?b"));
        System.out.println(new RegularIsMatch2().isMatch("", "******"));
    }

    public boolean isMatch(String s, String p) {
        if (Objects.equals(s, p)) {
            return true;
        } else if (Objects.isNull(s) || Objects.isNull(p)) {
            return false;
        }

        dp(s, p, 0, 0);
        return memo.getOrDefault("0-0", false);
    }

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean dp(String s, String p, int i, int j) {
        String key = i + "-" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (j == p.length()) {
            memo.put(key, i == s.length());
            return memo.get(key);
        }
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            memo.put(key, true);
            return true;
        }

        boolean result;
        boolean first = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
        if (p.charAt(j) == '*') {
            result = dp(s, p, i, j + 1) || dp(s, p, i + 1, j);
        } else {
            result = first && dp(s, p, i + 1, j + 1);
        }

        memo.put(key, result);
        return result;
    }
}
