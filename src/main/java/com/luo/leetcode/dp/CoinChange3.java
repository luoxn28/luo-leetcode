package com.luo.leetcode.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 * 零钱数量固定场景下某个数值金额最少需要的零钱个数问题
 *
 * @author luoxiangnan
 * @date 2020-10-31
 */
public class CoinChange3 {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 2, 4, 5};
        int amount = 9;
        System.out.println(new CoinChange3().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
        }

        for (int j = 0; j <= coins.length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= coins.length; j++) {
                if (i - coins[j - 1] < 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - coins[j - 1]][j - 1] + 1,
                            dp[i][j - 1]);
                }
            }
        }
        return dp[amount][coins.length] == Integer.MAX_VALUE - 1 ? -1 : dp[amount][coins.length];
    }
}
