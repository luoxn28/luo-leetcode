package com.luo.leetcode.dp;

/**
 * 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 *
 * @author luoxiangnan
 * @date 2020-11-06
 */
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence_dp("abc", "ahbgdc"));

        System.out.println(new IsSubsequence().isSubsequence("axc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence_dp("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, fromIndex = 0;
        for (; i < s.length() && fromIndex < t.length(); i++) {
            int index = t.indexOf(s.charAt(i), fromIndex);
            if (index == -1) {
                return false;
            }

            fromIndex = index + 1;
        }
        return i == s.length();
    }

    /**
     * 动态规划实现方式
     */
    public boolean isSubsequence_dp(String s, String t) {
        boolean[][] dp = new boolean[s.length()][t.length()];

        for (int j = 0; j < t.length(); j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length() - 1][t.length() - 1];
    }
}
