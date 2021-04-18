package com.luo.leetcode.backtrack;

/**
 * @author luoxiangnan
 * @date 2021-04-16
 */
public class FindCircleNum {

    public static void main(String[] args) {
        System.out.println(new FindCircleNum().findCircleNum(new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 1, 0},
                new int[]{0, 0, 1}
        }));

        System.out.println(new FindCircleNum().findCircleNum(new int[][]{
                new int[]{1, 0, 0, 1},
                new int[]{0, 1, 1, 0},
                new int[]{0, 1, 1, 1},
                new int[]{1, 0, 1, 1}
        }));
    }

    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                ans += track(isConnected, i, j);
            }
        }

        return ans;
    }

    private int track(int[][] isConnected, int i, int j) {
        if (i < 0 || i >= isConnected.length || j < 0 || j >= isConnected[0].length || isConnected[i][j] == 0) {
            return 0;
        }

        // 一行 一列 进行递归处理
        isConnected[i][j] = 0;
        for (int ii = 0; ii < isConnected.length; ii++) {
            track(isConnected, ii, j);
        }
        for (int jj = 0; jj < isConnected[0].length; jj++) {
            track(isConnected, i, jj);
        }

        return 1;
    }
}
