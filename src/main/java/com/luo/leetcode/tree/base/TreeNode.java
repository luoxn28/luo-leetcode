package com.luo.leetcode.tree.base;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxiangnan
 * @date 2020-09-29
 */
@NoArgsConstructor
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return middleOrderTravel(this, new ArrayList<>()).toString();
    }

    private List<Integer> middleOrderTravel(TreeNode node, List<Integer> result) {
        if (node == null) {
            return result;
        }

        middleOrderTravel(node.left, result);
        result.add(node.val);
        middleOrderTravel(node.right, result);
        return result;
    }
}
