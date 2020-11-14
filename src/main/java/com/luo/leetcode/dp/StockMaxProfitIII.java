package com.luo.leetcode.dp;

/**
 * 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author luoxiangnan
 * @date 2020-11-14
 */
public class StockMaxProfitIII {

    public static void main(String[] args) {
        System.out.println(new StockMaxProfitIII().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new StockMaxProfitIII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new StockMaxProfitIII().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        return maxProfit(2, prices);
    }

    private int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        } else if (k > prices.length / 2) {
            k = prices.length;
        }

        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][k][0];
    }
}
