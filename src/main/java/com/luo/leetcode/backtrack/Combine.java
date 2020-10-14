package com.luo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author luoxiangnan
 * @date 2020-10-15
 */
public class Combine {

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        backtrace(n, 1, new LinkedList<>(), k);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    public void backtrace(int n, int start, LinkedList<Integer> path, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.addLast(i);
            backtrace(n, i + 1, path, k);
            path.removeLast();
        }
    }
}
