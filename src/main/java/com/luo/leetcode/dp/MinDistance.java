package com.luo.leetcode.dp;

/**
 * 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * @author luoxiangnan
 * @date 2020-10-11
 */
public class MinDistance {

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("horse", "ros"));
        System.out.println(new MinDistance().minDistance("intention", "execution"));
        System.out.println(new MinDistance().minDistance("", "a"));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i][j - 1] + 1, // 增加
                            Math.min(
                                    dp[i - 1][j] + 1, // 减少
                                    dp[i - 1][j - 1] + 1 // 替换
                            )
                    );
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
