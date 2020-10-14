package com.luo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author luoxiangnan
 * @date 2020-10-14
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0, new LinkedList<>());
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    public void backtrace(int[] nums, int start, LinkedList<Integer> path) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrace(nums, i + 1, path);
            path.removeLast();
        }
    }
}
