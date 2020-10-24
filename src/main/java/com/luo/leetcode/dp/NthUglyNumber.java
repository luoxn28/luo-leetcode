package com.luo.leetcode.dp;

/**
 * 丑数 II
 * https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * @author luoxiangnan
 * @date 2020-10-24
 */
public class NthUglyNumber {

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[1690];
        int i2 = 0, i3 = 0, i5 = 0;

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (dp[i] == dp[i2] * 2) i2++;
            if (dp[i] == dp[i3] * 3) i3++;
            if (dp[i] == dp[i5] * 5) i5++;
        }
        return dp[n - 1];
    }
}
