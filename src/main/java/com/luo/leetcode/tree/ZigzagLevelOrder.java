package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 103. 二叉树的锯齿形层序遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author luoxiangnan
 * @date 2021-04-16
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        boolean asc = true;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        while (!level.isEmpty()) {
            if (asc) {
                result.add(level.stream().map(o -> o.val).collect(Collectors.toList()));
            } else {
                List<Integer> ans = new ArrayList<>();
                for (int i = level.size() - 1; i >= 0; i--) {
                    ans.add(level.get(i).val);
                }
                result.add(ans);
            }
            asc = !asc;

            List<TreeNode> current = new ArrayList<>();
            for (TreeNode node : level) {
                if (node.left != null) {
                    current.add(node.left);
                }
                if (node.right != null) {
                    current.add(node.right);
                }
            }

            level = current;
        }

        return result;
    }

}
