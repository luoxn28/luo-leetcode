package com.luo.leetcode.tree.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxiangnan
 * @date 2020-09-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
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
