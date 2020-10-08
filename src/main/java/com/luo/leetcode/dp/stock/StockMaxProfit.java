package com.luo.leetcode.dp.stock;

/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author luoxiangnan
 * @date 2020-10-08
 */
public class StockMaxProfit {

    public static void main(String[] args) {
        {
            int[] stocks = new int[]{7, 1, 5, 3, 6, 4};
            System.out.println(new StockMaxProfit().maxProfit(stocks));
        }

        {
            int[] stocks = new int[]{7, 6, 4, 3, 1};
            System.out.println(new StockMaxProfit().maxProfit(stocks));
        }
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
