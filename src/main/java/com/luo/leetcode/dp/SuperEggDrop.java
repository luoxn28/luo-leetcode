package com.luo.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 鸡蛋掉落
 * https://leetcode-cn.com/problems/super-egg-drop/
 *
 * @author luoxiangnan
 * @date 2020-10-09
 */
public class SuperEggDrop {

    public static void main(String[] args) {
        System.out.println(new SuperEggDrop().superEggDrop(1, 2));
        System.out.println(new SuperEggDrop().superEggDrop2(1, 2));

        System.out.println(new SuperEggDrop().superEggDrop(2, 6));
        System.out.println(new SuperEggDrop().superEggDrop2(2, 6));

        System.out.println(new SuperEggDrop().superEggDrop(3, 14));
        System.out.println(new SuperEggDrop().superEggDrop2(3, 14));

        System.out.println(new SuperEggDrop().superEggDrop(3, 25));
        System.out.println(new SuperEggDrop().superEggDrop2(3, 25));

//        System.out.println(new SuperEggDrop().superEggDrop(4, 5000));
        System.out.println(new SuperEggDrop().superEggDrop2(4, 5000));
    }

    /**
     * 更高效的方法
     */
    int superEggDrop2(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];

        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        return m;
    }

    public int superEggDrop(int K, int N) {
        return superEggDrop(K, N, new HashMap<>());
    }

    public int superEggDrop(int K, int N, Map<String, Integer> memo) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }

        String key = K + "-" + N;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(
                    superEggDrop(K, N - i, memo), // 鸡蛋未碎
                    superEggDrop(K - 1, i - 1, memo) // 鸡蛋已碎
            ) + 1);
        }
        memo.put(key, res);
        return res;
    }
}
