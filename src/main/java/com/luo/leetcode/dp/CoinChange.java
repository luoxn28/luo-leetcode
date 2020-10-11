package com.luo.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * 重要的是状态转移方程：f(n) = f(n-coin) + 1，边界条件是 amount<0和amount=0情况
 *
 * @author luoxiangnan
 * @date 2020-09-29
 */
public class CoinChange {

    public static void main(String[] args) {
        {
            int[] coins = new int[]{1, 2, 5};
            int amount = 11;
            System.out.println(new CoinChange().coinChange(coins, amount));
        }
        {
            int[] coins = new int[]{2};
            int amount = 3;
            System.out.println(new CoinChange().coinChange(coins, amount));
        }
        {
            int[] coins = new int[]{1};
            int amount = 0;
            System.out.println(new CoinChange().coinChange(coins, amount));
        }
        {
            int[] coins = new int[]{1};
            int amount = 1;
            System.out.println(new CoinChange().coinChange(coins, amount));
        }
        {
            int[] coins = new int[]{1};
            int amount = 2;
            System.out.println(new CoinChange().coinChange(coins, amount));
        }
        {
            int[] coins = new int[]{1, 2, 5};
            int amount = 100;
            System.out.println(new CoinChange().coinChange(coins, amount));
        }
    }


    private Map<Integer, Integer> dp = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        } else if (amount == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            Integer res = dp.get(amount - coin);
            if (res == null) {
                res = coinChange(coins, amount - coin);
                dp.put(amount - coin, res);
            }

            if (res != -1) {
                result = Math.min(result, res + 1);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
