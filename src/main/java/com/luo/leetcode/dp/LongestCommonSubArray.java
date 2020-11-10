package com.luo.leetcode.dp;

/**
 * @author luoxiangnan
 * @date 2020-11-10
 */
public class LongestCommonSubArray {

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubArray().longestCommonSubArray("abcde", "ace"));
        System.out.println(new LongestCommonSubArray().longestCommonSubArray("aaacde", "ace"));
        System.out.println(new LongestCommonSubArray().longestCommonSubArray("abc", "abc"));
        System.out.println(new LongestCommonSubArray().longestCommonSubArray("abc", "def"));
    }

    public int longestCommonSubArray(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
