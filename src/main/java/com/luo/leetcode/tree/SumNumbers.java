package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

/**
 * 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 *
 * @author luoxiangnan
 * @date 2020-10-29
 */
public class SumNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new SumNumbers().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        backtrack(root);
        return result;
    }

    private int result = 0;
    private StringBuilder sb = new StringBuilder();

    public void backtrack(TreeNode node) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            sb.append(node.val);
            result += Integer.valueOf(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        sb.append(node.val);
        backtrack(node.left);
        backtrack(node.right);
        sb.deleteCharAt(sb.length() - 1);
    }
}
