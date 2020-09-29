package com.luo.leetcode.tree.base;

import lombok.NoArgsConstructor;

/**
 * @author luoxiangnan
 * @date 2020-09-29
 */
@NoArgsConstructor
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
