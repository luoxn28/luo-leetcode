package com.luo.leetcode.backtrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author luoxiangnan
 * @date 2021-01-10
 */
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(new CombinationSum().combinationSum(new int[]{14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12}, 27));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, new LinkedList<>(), 0);
        return result;
    }

    private List<List<Integer>> result = new ArrayList<>();
    private Set<String> cache = new HashSet<>();

    private void backtrack(int[] candidates, int start, int target,
                           LinkedList<Integer> paths, int sum) {
        if (sum == target) {
            List<Integer> value = paths.stream().sorted().collect(Collectors.toList());
            String key = value.toString();
            if (!cache.contains(key)) {
                cache.add(key);
                result.add(value);
            }
            return;
        } else if (start >= candidates.length || sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            paths.add(candidates[i]);
            backtrack(candidates, i + 1, target, paths, sum += candidates[i]);

            paths.removeLast();
            sum -= candidates[i];
        }
    }
}
