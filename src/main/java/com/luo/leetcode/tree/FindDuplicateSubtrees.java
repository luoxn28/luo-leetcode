package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 *
 * @author luoxiangnan
 * @date 2020-10-23
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        walk(root);
        return result;
    }

    private Map<String, Integer> memo = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public String walk(TreeNode node) {
        if (node == null) {
            return "#";
        }

        String left = walk(node.left);
        String right = walk(node.right);
        String key = left + "," + right + "," + node.val;
        int num = memo.getOrDefault(key, 0);
        if (num == 1) {
            result.add(node);
        }
        memo.put(key, num + 1);
        return key;
    }
}
