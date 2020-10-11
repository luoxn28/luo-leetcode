package com.luo.leetcode.dp;

import com.luo.leetcode.tree.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 *
 * @author luoxiangnan
 * @date 2020-10-11
 */
public class RobTree {

    public static void main(String[] args) {

    }

    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int doVal = root.val +
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int noDoVal = rob(root.left) + rob(root.right);
        int val = Math.max(doVal, noDoVal);
        memo.put(root, val);
        return val;
    }
}
