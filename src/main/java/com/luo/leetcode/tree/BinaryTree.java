package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分树
 *
 * @author luoxiangnan
 * @date 2020-09-29
 */
public class BinaryTree {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        // 不交换值，交换指针
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }

    private List<Integer> postorderTraversal(TreeNode root) {
        return postOrderTraversal(root, new ArrayList<>());
    }

    private List<Integer> postOrderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return result;
        }

        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.add(node.val);
        return result;
    }
}
