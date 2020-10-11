package com.luo.leetcode.dp;

/**
 * 让字符串成为回文串的最少插入次数
 * https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 *
 * @author luoxiangnan
 * @date 2020-10-11
 */
public class MinInsertions {

    public static void main(String[] args) {
        System.out.println(new MinInsertions().minInsertions("zzazz"));
        System.out.println(new MinInsertions().minInsertions("mbadm"));
        System.out.println(new MinInsertions().minInsertions("leetcode"));
        System.out.println(new MinInsertions().minInsertions("g"));
        System.out.println(new MinInsertions().minInsertions("no"));
    }

    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n-1];
    }
}
