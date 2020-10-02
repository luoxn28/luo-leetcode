package com.luo.leetcode.tree.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxiangnan
 * @date 2020-10-02
 */
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return middleOrderTravel(this, new ArrayList<>()).toString();
    }

    private List<Integer> middleOrderTravel(Node node, List<Integer> result) {
        if (node == null) {
            return result;
        }

        middleOrderTravel(node.left, result);
        result.add(node.val);
        middleOrderTravel(node.right, result);
        return result;
    }
}
