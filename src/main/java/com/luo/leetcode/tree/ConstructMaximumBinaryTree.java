package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;
import javafx.util.Pair;

/**
 * 最大二叉树
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 *
 * @author luoxiangnan
 * @date 2020-10-09
 */
public class ConstructMaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        System.out.println(new ConstructMaximumBinaryTree().constructMaximumBinaryTree(nums));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        Pair<Integer, Integer> valueIndex = maxValueIndex(nums, left, right);
        TreeNode root = new TreeNode(valueIndex.getKey());
        root.left = constructMaximumBinaryTree(nums, left, valueIndex.getValue() - 1);
        root.right = constructMaximumBinaryTree(nums, valueIndex.getValue() + 1, right);
        return root;
    }

    private Pair<Integer, Integer> maxValueIndex(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE, index = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return new Pair<>(max, index);
    }
}
