package com.luo.leetcode.bfs;

import com.luo.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author luoxiangnan
 * @date 2020-10-05
 */
public class MinDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(new MinDepth().minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);

        int depth = 1;
        while (!nodeList.isEmpty()) {
            List<TreeNode> childList = new ArrayList<>();
            for (TreeNode node : nodeList) {
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    childList.add(node.left);
                }
                if (node.right != null) {
                    childList.add(node.right);
                }
            }

            nodeList = childList;
            depth++;
        }
        return depth;
    }
}
