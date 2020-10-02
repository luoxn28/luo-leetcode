package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

/**
 * 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @author luoxiangnan
 * @date 2020-10-02
 */
public class SameTree {

    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
