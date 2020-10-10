package com.luo.leetcode.dp;

/**
 * 01背包
 *
 * @author luoxiangnan
 * @date 2020-10-10
 */
public class Knapsack01 {

    public static void main(String[] args) {
        int N = 3, W = 4;
        int[] wt = new int[]{2, 1, 3}, val = new int[]{4, 2, 3};
        System.out.println(new Knapsack01().knapsack(W, N, wt, val));
    }

    public int knapsack(int W, int N, int[] weights, int[] values) {
        // dp[n][w]表示：对于前n个物品背包容量为w时，可以装的最大价值
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - weights[i - 1] < 0) {
                    // 装不下
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(
                            dp[i - 1][w], // 不装
                            dp[i - 1][w - weights[i - 1]] + values[i - 1] // 装
                    );
                }
            }
        }
        return dp[N][W];
    }
}
