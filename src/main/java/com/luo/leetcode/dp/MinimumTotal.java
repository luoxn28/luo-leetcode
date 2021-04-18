package com.luo.leetcode.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author luoxiangnan
 * @date 2021-04-17
 */
public class MinimumTotal {

    public static void main(String[] args) {
        System.out.println(new MinimumTotal().minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        )));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[length];

        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                int num = list.get(j);
                if (j == 0) {
                    dp[0] = dp[0] + num;
                } else if (j == list.size() - 1) {
                    dp[j] = dp[j - 1] + num;
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + num;
                }
            }
            System.out.println(Arrays.toString(dp));
        }


        int ans = Integer.MAX_VALUE;
        for (int num : dp) {
            ans = Math.min(num, ans);
        }
        return ans;
    }
}
