package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author luoxiangnan
 * @date 2020-10-19
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, null);
    }
}
