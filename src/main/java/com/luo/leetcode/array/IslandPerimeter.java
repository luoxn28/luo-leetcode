package com.luo.leetcode.array;

/**
 * 岛屿的周长
 * https://leetcode-cn.com/problems/island-perimeter/
 *
 * @author luoxiangnan
 * @date 2020-10-14
 */
public class IslandPerimeter {

    public static void main(String[] args) {

    }

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return 1;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = -1;
        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) +
                dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}
