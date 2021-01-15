package com.luo.leetcode.并查集;

/**
 * @author luoxiangnan
 * @date 2021-01-15
 */
public class NumIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(new NumIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int mn = m * n;
        UF uf = new UF(mn + 1);

        int[][] dir = new int[][]{{0, 1}, {1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    uf.union(i * n + j, mn);
                } else {
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == '1') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }

        return uf.count - 1;
    }


}
