package com.luo.leetcode.dp;

/**
 * 最大矩形
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * @author luoxiangnan
 * @date 2020-10-31
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        {
            char[][] matrix = new char[4][5];
            matrix[0] = new char[]{'1', '0', '1', '0', '0'};
            matrix[1] = new char[]{'1', '0', '1', '1', '1'};
            matrix[2] = new char[]{'1', '1', '1', '1', '1'};
            matrix[3] = new char[]{'1', '0', '0', '1', '0'};
            System.out.println(new MaximalRectangle().maximalRectangle(matrix));
        }

        {
            char[][] matrix = new char[1][1];
            matrix[0] = new char[]{'1'};
            System.out.println(new MaximalRectangle().maximalRectangle(matrix));
        }


    }

    public int maximalRectangle(char[][] matrix) {
        int maxSize = 0;
        if (matrix == null || matrix.length == 0) {
            return maxSize;
        }

        // dp[i][j]表示当前点上最大高度
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] != '1') {
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = i == 0 ? 1 : dp[i - 1][j] + 1;
                    maxSize = Math.max(maxSize, dp[i][j]);
                    continue;
                }

                int curHeight = dp[i][j] = (i == 0 ? 1 : dp[i - 1][j] + 1);
                for (int k = j; k >= 0 && matrix[i][k] != '0'; k--) {
                    curHeight = Math.min(curHeight, dp[i][k]);
                    int curWidth = j - k + 1;
                    maxSize = Math.max(maxSize, curHeight * curWidth);
                }
            }
        }

        return maxSize;
    }
}
