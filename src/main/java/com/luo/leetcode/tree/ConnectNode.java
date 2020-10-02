package com.luo.leetcode.tree;

import com.luo.leetcode.tree.base.Node;

/**
 * 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author luoxiangnan
 * @date 2020-10-02
 */
public class ConnectNode {

    public Node connect(Node root) {
        if (root != null) {
            connectTowNode(root.left, root.right);
        }
        return root;
    }

    /**
     * 递归，确定边界条件&&确定当前递归层次所做事情
     */
    public void connectTowNode(Node left, Node right) {
        if (left == null && right == null) {
            return;
        } else if (left == null) {
            connectTowNode(right.left, right.right);
            return;
        } else if (right == null) {
            connectTowNode(left.left, left.right);
            return;
        }

        left.next = right;
        connectTowNode(left.left, left.right);
        connectTowNode(right.left, right.right);
        connectTowNode(left.right, right.left);
    }
}
