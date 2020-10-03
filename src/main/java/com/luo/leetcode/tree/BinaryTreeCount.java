package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

/**
 * 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 *
 * @author luoxiangnan
 * @date 2020-10-02
 */
public class BinaryTreeCount {

    public int countNodes(TreeNode root) {
        TreeNode left = root, right = root;

        int h1 = 0;
        while (left != null) {
            left = left.left;
            h1++;
        }

        int h2 = 0;
        while (right != null) {
            right = right.right;
            h2++;
        }

        if (h1 == h2) {
            return (int) Math.pow(2, h1) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
