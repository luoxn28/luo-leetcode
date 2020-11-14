package com.luo.leetcode.dp;

/**
 * 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @author luoxiangnan
 * @date 2020-11-14
 */
public class StockMaxProfitIV {

    public static void main(String[] args) {
        System.out.println(new StockMaxProfitIV().maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(new StockMaxProfitIV().maxProfit(new int[]{2, 1, 4}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            } else if (i == 1) {
                dp[1][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[1][1] = Math.max(dp[i - 1][1], -prices[i]);
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
