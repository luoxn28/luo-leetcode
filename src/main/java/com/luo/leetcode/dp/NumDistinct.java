package com.luo.leetcode.dp;

/**
 * 不同的子序列
 * https://leetcode-cn.com/problems/distinct-subsequences/
 *
 * @author luoxiangnan
 * @date 2020-10-30
 */
public class NumDistinct {

    public static void main(String[] args) {
        {
            String S = "rabbbit", T = "rabbit";
            System.out.println(new NumDistinct().numDistinct(S, T));
        }
        {
            String S = "babgbag", T = "bag";
            System.out.println(new NumDistinct().numDistinct(S, T));
        }
    }

    public int numDistinct(String s, String t) {
        int li = t.length(), lj = s.length();
        int[][] dp = new int[li + 1][lj + 1];

        for (int i = 0; i < li; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < lj; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= li; i++) {
            for (int j = 1; j <= lj; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[li][lj];
    }
}
