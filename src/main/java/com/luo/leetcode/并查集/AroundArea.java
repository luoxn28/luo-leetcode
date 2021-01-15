package com.luo.leetcode.并查集;

import java.util.Arrays;

/**
 * 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * @author luoxiangnan
 * @date 2021-01-15
 */
public class AroundArea {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

        new AroundArea().solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        int dummy = m * n;
        UF uf = new UF(dummy + 1);

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, dummy);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                uf.union(j, dummy);
            }
            if (board[m - 1][j] == 'O') {
                uf.union(n * (m - 1) + j, dummy);
            }
        }

        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (board[x][y] == 'O') {
                            uf.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !uf.connected(dummy, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
