package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

/**
 * 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author luoxiangnan
 * @date 2021-01-20
 */
public class BuildTree {

    public static void main(String[] args) {
        System.out.println(new BuildTree().buildTree(
                new int[]{9, 3, 15, 20, 7},
                new int[]{9, 15, 7, 20, 3}));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int index = 0;
        int rootVal = postorder[postEnd];
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
