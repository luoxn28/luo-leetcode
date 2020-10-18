package com.luo.leetcode.dp;

import java.util.Arrays;

/**
 * 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * @author luoxiangnan
 * @date 2020-10-17
 */
public class CountSubstrings {

    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("abc"));
        System.out.println(new CountSubstrings().countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);

        for (int i = 1; i < s.length(); i++) {
            dp[i] += dp[i - 1];
            for (int j = 0; j < i; j++) {
                if (isPalindromeString(s, j, i)) {
                    dp[i]++;
                }
            }
        }
        return dp[s.length() - 1];
    }

    private boolean isPalindromeString(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
