package com.luo.leetcode.dp;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 *
 * @author luoxiangnan
 * @date 2021-04-22
 */
public class MaxSumSubmatrix {

    public static void main(String[] args) {
        System.out.println(new MaxSumSubmatrix().maxSumSubmatrix(new int[][]{
                new int[]{1, 0, 1},
                new int[]{0, -2, 3}
        }, 2));
        System.out.println(new MaxSumSubmatrix().maxSumSubmatrix(new int[][]{
                new int[]{2, 2, -1}
        }, 3));
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rowSize = matrix.length, columnSize = matrix[0].length;

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= rowSize; i++) {
            for (int j = 1; j <= columnSize; j++) {
                // dp动态数组
                int[][] dp = new int[rowSize + 1][columnSize + 1];

                for (int m = i; m <= rowSize; m++) {
                    for (int n = j; n <= columnSize; n++) {
                        dp[m][n] = dp[m - 1][n] + dp[m][n - 1] - dp[m - 1][n - 1] + matrix[m - 1][n - 1];
                        if (dp[m][n] <= k && dp[m][n] > ans) {
                            ans = dp[m][n];
                        }
                    }
                }
            }
        }

        return ans;
    }
}
