package com.luo.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author luoxiangnan
 * @date 2020-11-14
 */
public class ColorBorder {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        new ColorBorder().colorBorder(grid, 1, 1, 2);
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (!inImage(grid, r0, c0)) {
            return grid;
        }

        colorBorder(grid, r0, c0, grid[r0][c0], color);
        return grid;
    }

    private Set<String> visited = new HashSet<>();

    private int colorBorder(int[][] grid, int i, int j, int oldColor, int newColor) {
        if (!inImage(grid, i, j)) {
            return 0;
        } else if (visited.contains(i + ":" + j)) {
            return 1;
        } else if (grid[i][j] != oldColor) {
            return 0;
        }

        visited.add(i + ":" + j);
        int result = colorBorder(grid, i, j + 1, oldColor, newColor) +
                colorBorder(grid, i, j - 1, oldColor, newColor) +
                colorBorder(grid, i + 1, j, oldColor, newColor) +
                colorBorder(grid, i - 1, j, oldColor, newColor);
        if (result < 4) {
            grid[i][j] = newColor;
        }
        return 1;
    }

    private boolean inImage(int[][] grid, int i, int j) {
        return 0 <= i && i < grid.length && 0 <= j && j < grid[0].length;
    }
}
