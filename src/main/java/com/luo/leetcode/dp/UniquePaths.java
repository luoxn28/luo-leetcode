package com.luo.leetcode.dp;

/**
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @author luoxiangnan
 * @date 2020-10-18
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 2));
        System.out.println(new UniquePaths().uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
