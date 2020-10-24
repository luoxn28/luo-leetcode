package com.luo.leetcode.collection;

import com.luo.leetcode.collection.base.ListNode;

/**
 * @author luoxiangnan
 * @date 2020-10-23
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = lenListNode(l1);
        int len2 = lenListNode(l2);

        ListNode head = l1, node1 = l1, node2 = l2;
        if (len1 < len2) {
            head = l2;
            node1 = l2;
            node2 = l1;
        }

        int num = 0;
        while (node1 != null && node2 != null) {
            num += node1.val + node2.val;
            node1.val = num % 10;
            num = num / 10;

            if (node1.next == null && num > 0) {
                node1.next = new ListNode(num);
                break;
            } else if (node2.next == null && num > 0) {
                node2.next = new ListNode(num);
                num = 0;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        return head;
    }

    private int lenListNode(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
