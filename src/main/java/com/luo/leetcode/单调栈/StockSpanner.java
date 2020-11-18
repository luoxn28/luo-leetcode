package com.luo.leetcode.单调栈;

import javafx.util.Pair;

import java.util.Stack;

/**
 * @author luoxiangnan
 * @date 2020-11-18
 */
public class StockSpanner {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(85));
        System.out.println(stockSpanner.next(76));
        System.out.println(stockSpanner.next(43));
        System.out.println(stockSpanner.next(26));
        System.out.println(stockSpanner.next(52));
    }

    private Stack<Pair<Integer, Integer>> stack = new Stack<>();

    public StockSpanner() {
    }

    public int next(int price) {
        Integer res = 1;
        while (!stack.isEmpty() && price >= stack.peek().getKey()) {
            res += stack.pop().getValue();
        }

        stack.push(new Pair<>(price, res));
        return res;
    }
}
