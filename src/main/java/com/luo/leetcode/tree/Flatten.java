package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

/**
 * 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author luoxiangnan
 * @date 2020-10-02
 */
public class Flatten {

    /**
     * 递归方法实现，将左侧节点放到右侧节点位置，原右侧节点放到原左侧节点的尾部。
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        node.right = right;
    }
}
