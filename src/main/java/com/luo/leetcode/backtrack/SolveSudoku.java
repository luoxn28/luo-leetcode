package com.luo.leetcode.backtrack;

/**
 * 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 *
 * @author luoxiangnan
 * @date 2020-10-12
 */
public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    public boolean backtrack(char[][] board, int si, int sj) {
        if (sj == 9) {
            return backtrack(board, si + 1, 0);
        } else if (si == 9) {
            return true;
        }

        for (int i = si; i < 9; i++) {
            for (int j = sj; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 已指定不再处理
                    return backtrack(board, si, sj + 1);
                }

                for (char ch = '1'; ch <= '9'; ch++) {
                    if (!isValid(board, i, j, ch)) {
                        continue;
                    }

                    board[i][j] = ch;
                    if (backtrack(board, i, j + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }

                // 穷举完 1~9，依然没有找到可行解，此路不通
                return false;
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == ch) return false;
            if (board[r][i] == ch) return false;
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch) return false;
        }
        return true;
    }
}
