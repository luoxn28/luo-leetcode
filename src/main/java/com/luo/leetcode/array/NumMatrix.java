package com.luo.leetcode.array;

/**
 * 二维区域和检索 - 矩阵不可变
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 *
 * @author luoxiangnan
 * @date 2020-10-31
 */
public class NumMatrix {

    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sumMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sumMatrix[i][j] = add(matrix, i, j);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sumMatrix == null) {
            return 0;
        }
        return get(row2, col2) - get(row1 - 1, col2) - get(row2, col1 - 1) + get(row1 - 1, col1 - 1);
    }

    private int add(int[][] matrix, int i, int j) {
        if (i == 0 && j == 0) {
            return matrix[i][j];
        } else if (i == 0) {
            return sumMatrix[i][j - 1] + matrix[i][j];
        } else if (j == 0) {
            return sumMatrix[i - 1][j] + matrix[i][j];
        } else {
            return sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j];
        }
    }

    private int get(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        return sumMatrix[i][j];
    }
}
