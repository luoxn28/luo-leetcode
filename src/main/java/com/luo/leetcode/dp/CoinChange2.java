package com.luo.leetcode.dp;

/**
 * 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 *
 * @author luoxiangnan
 * @date 2020-10-10
 */
public class CoinChange2 {

    public static void main(String[] args) {
        {
            int[] coins = new int[]{1, 2, 5};
            System.out.println(new CoinChange2().change(5, coins));
        }

        {
            int[] coins = new int[]{2};
            System.out.println(new CoinChange2().change(3, coins));
        }

        {
            int[] coins = new int[]{10};
            System.out.println(new CoinChange2().change(10, coins));
        }
    }

    public int change(int amount, int[] coins) {
        // dp[i][w]表示：i种零钱兑换w金额时的最大组合数
        int[][] dp = new int[coins.length + 1][amount + 1];

        // 0种零钱兑换任何金额都是0
//        for (int w = 0; w <= amount; w++) {
//            dp[0][w] = 0;
//        }
        // 任何零钱兑换0金额都是1
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int w = 1; w <= amount; w++) {
                if (w - coins[i - 1] < 0) {
                    // 装不下
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = dp[i - 1][w] // 不装
                            + dp[i][w - coins[i - 1]]; // 装
                }
            }
        }

        return dp[coins.length][amount];
    }
}
