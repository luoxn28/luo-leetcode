package com.luo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author luoxiangnan
 * @date 2020-09-20
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        permute(nums).forEach(System.out::println);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new LinkedList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> paths, List<List<Integer>> result) {
        if (paths.size() == nums.length) {
            result.add(new ArrayList<>(paths));
            return;
        }

        for (int num : nums) {
            if (paths.contains(num)) {
                continue;
            }

            paths.add(num);
            backtrack(nums, paths, result);
            paths.removeLast();
        }
    }
}
