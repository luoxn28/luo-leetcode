package com.luo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author luoxiangnan
 * @date 2020-10-09
 */
public class NSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new NSum().threeSum(nums));
    }

    /**
     * 3数之和
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            twoSum(nums, i + 1, 0 - value).forEach(list -> {
                List<Integer> res = new ArrayList<>();
                res.add(value);
                res.addAll(list);
                result.add(res);
            });

            while (i < nums.length - 1 && nums[i + 1] == value) {
                i++;
            }
        }
        return result;
    }

    /**
     * 2数之和
     */
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int lo = start, ro = nums.length - 1;
        while (lo < ro) {
            int left = nums[lo], right = nums[ro];
            int sum = left + right;
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                ro--;
            } else {
                result.add(Arrays.asList(nums[lo], nums[ro]));
                while (lo < nums.length && nums[lo] == left) {
                    lo++;
                }
                while (ro >= 0 && nums[ro] == right) {
                    ro--;
                }
            }
        }
        return result;
    }
}
