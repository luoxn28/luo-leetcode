package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

/**
 * 恢复二叉搜索树
 * 1. 按照中序遍历模板，2个节点位置错误，在中序遍历中也就是说当前节点小于前一个节点时表示位置有误。
 * 2. 找出待恢复的2个节点，这两个节点的分布情况有2种：相邻或者不相邻。
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 *
 * @author luoxiangnan
 * @date 2020-09-29
 */
public class RecoverBinaryTree {

    public static void main(String[] args) {
        {
            TreeNode root = new TreeNode(1);
            TreeNode node3 = root.left = new TreeNode(3);
            TreeNode node2 = node3.right = new TreeNode(2);

            System.out.println(root);
            new RecoverBinaryTree().recoverTree(root);
            System.out.println(root);
        }

        {
            TreeNode root = new TreeNode(3);
            TreeNode node1 = root.left = new TreeNode(1);
            TreeNode node4 = root.right = new TreeNode(4);
            TreeNode node2 = node4.left = new TreeNode(2);

            System.out.println(root);
            new RecoverBinaryTree().recoverTree(root);
            System.out.println(root);
        }
    }

    public void recoverTree(TreeNode root) {
        middleOrderTravel(root);
        if (node1 != null && node2 != null) {
            int value = node1.val;
            node1.val = node2.val;
            node2.val = value;
        }
    }

    private TreeNode prev;
    private TreeNode node1, node2;

    public void middleOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }

        middleOrderTravel(node.left);
        if (prev != null && node.val < prev.val) {
            if (node1 == null) {
                node1 = prev;
            }
            node2 = node;
        }
        prev = node;
        middleOrderTravel(node.right);
    }
}
