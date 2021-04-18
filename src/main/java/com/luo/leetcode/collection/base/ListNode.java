package com.luo.leetcode.collection.base;

/**
 * @author luoxiangnan
 * @date 2020-10-03
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode next(int next) {
        return this.next = new ListNode(next);
    }

    public ListNode(int... nums) {
        this.val = nums[0];
        ListNode node = this;
        for (int i = 1; i < nums.length; i++) {
            node.next(nums[i]);
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode head = this;
        sb.append(head.val);
        while ((head = head.next) != null) {
            sb.append("->").append(head.val);
        }
        return sb.toString();
    }
}
