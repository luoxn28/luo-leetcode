package com.luo.leetcode.backtrack;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @author luoxiangnan
 * @date 2020-09-20
 */
public class NQueen {

    public static void main(String[] args) {
        System.out.println(new NQueen().totalNQueens(8));
    }

    public int totalNQueens(int n) {
        solveNQueens(0, n, new LinkedList<>());
        return num;
    }

    int num = 0;

    public void solveNQueens(int i, int end, LinkedList<Pair<Integer, Integer>> paths) {
        if (paths.size() == end) {
            num++;
            return;
        } else if (i >= end) {
            return;
        }

        for (int j = 0; j < end; j++) {
            if (!listIsValid(paths, i, j)) {
                continue;
            }

            paths.add(new Pair<>(i, j));
            solveNQueens(i + 1, end, paths);
            paths.removeLast();
        }
    }

    /**
     * 约束条件（皇后不能处于同一行、不能处于同一列、不能同一个斜线上）
     */
    private static boolean listIsValid(List<Pair<Integer, Integer>> paths, int x, int y) {
        for (Pair<Integer, Integer> pair : paths) {
            if (pair.getKey() == x || pair.getValue() == y || Math.abs(x - pair.getKey()) == Math.abs(y - pair.getValue())) {
                return false;
            }
        }

        return true;
    }
}
