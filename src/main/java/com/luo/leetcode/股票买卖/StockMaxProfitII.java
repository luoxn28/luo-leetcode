package com.luo.leetcode.股票买卖;

/**
 * 买卖股票的最佳时机 II（可多次进行买卖）
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author luoxiangnan
 * @date 2020-11-14
 */
public class StockMaxProfitII {

    public static void main(String[] args) {
        System.out.println(new StockMaxProfitII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new StockMaxProfitII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new StockMaxProfitII().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
