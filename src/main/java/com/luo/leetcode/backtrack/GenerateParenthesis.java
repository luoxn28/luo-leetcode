package com.luo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author luoxiangnan
 * @date 2020-10-12
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, n, new LinkedList<>());
        return result;
    }

    private List<String> result = new ArrayList<>();

    public void generateParenthesis(int left, int right, LinkedList<String> path) {
        if (left < 0 || right < 0) return;
        if (left > right) return;
        if (left == 0 && right == 0) {
            result.add(toString(path));
            return;
        }

        path.addLast("(");
        generateParenthesis(left - 1, right, path);
        path.removeLast();

        path.addLast(")");
        generateParenthesis(left, right - 1, path);
        path.removeLast();
    }

    private String toString(LinkedList<String> path) {
        StringBuilder sb = new StringBuilder();
        path.forEach(sb::append);
        return sb.toString();
    }
}
