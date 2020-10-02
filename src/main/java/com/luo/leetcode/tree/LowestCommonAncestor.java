package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 注意不是二叉搜索树，节点的左子树不满足小于右子树的特性
 *
 * @author luoxiangnan
 * @date 2020-10-02
 */
public class LowestCommonAncestor {

    //[3,5,1,6,2,0,8,null,null,7,4]
    //5
    //4
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
