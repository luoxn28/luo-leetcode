package com.luo.leetcode.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author luoxiangnan
 * @date 2020-10-05
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(new Fib().fib(4));
    }

    Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }

        Integer result = cache.get(N);
        if (result != null) {
            return result;
        }

        result = fib(N - 1) + fib(N - 2);
        cache.put(N, result);
        return result;
    }
}
