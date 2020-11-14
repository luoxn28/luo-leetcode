package com.luo.leetcode.array;

import java.util.Arrays;

/**
 * @author luoxiangnan
 * @date 2020-11-14
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        new FloodFill().floodFill(image, 1, 1, 2);
        for (int[] ints : image) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        floodFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void floodFill(int[][] image, int i, int j, int oldColor, int newColor) {
        if (!inImage(image, i, j) || image[i][j] != oldColor) {
            return;
        }

        if (image[i][j] == -1) {
            // visited
            return;
        }

        image[i][j] = -1;
        floodFill(image, i, j + 1, oldColor, newColor);
        floodFill(image, i, j - 1, oldColor, newColor);
        floodFill(image, i + 1, j, oldColor, newColor);
        floodFill(image, i - 1, j, oldColor, newColor);
        image[i][j] = newColor;
    }

    private boolean inImage(int[][] iamge, int i, int j) {
        return 0 <= i && i < iamge.length && 0 <= j && j < iamge[0].length;
    }
}
