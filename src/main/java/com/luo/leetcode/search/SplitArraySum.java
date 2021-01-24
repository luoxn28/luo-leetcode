package com.luo.leetcode.search;

/**
 * 分割数组的最大值
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 *
 * @author luoxiangnan
 * @date 2021-01-24
 */
public class SplitArraySum {

    public static void main(String[] args) {
        System.out.println(new SplitArraySum().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    /**
     * 换个角度思考，相当于 遍历minSum到maxSum，当为sum时数组最小可分个数，如果刚好等于m，此时sum就是所要求的结果
     * minSum为数组中最大元素，maxSum为数组元素和。
     * 如果条件为正好等于m，那会不会遍历过程中直接跳过m导致不会有结果的？理论是有的，那么条件改成<=m是否可以？
     * 如果<m那么么，还可以再进行划分几个数组将其数量刚好等于m，因此结束条件是m
     */
    public int splitArray(int[] nums, int m) {
        int lo = getMax(nums);
        int hi = getSum(nums);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int n = splitArrayNum(nums, mid);

            if (n == m) {
                // 收缩右边界，达到搜索左边界的目的
                hi = mid;
            } else if (n < m) {
                // 最大子数组和上限高了，减小一些
                hi = mid;
            } else if (n > m) {
                // 最大子数组和上限低了，增加一些
                lo = mid + 1;
            }
        }

        return lo;
    }

    private int splitArrayNum(int[] nums, int max) {
        int cnt = 1;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum + nums[i] > max) {
                // 如果当前子数组和大于 max 限制
                // 则这个子数组不能再添加元素了
                cnt++;
                curSum = nums[i];
            } else {
                // 当前子数组和还没达到 max 限制
                // 还可以添加元素
                curSum += nums[i];
            }
        }
        return cnt;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
