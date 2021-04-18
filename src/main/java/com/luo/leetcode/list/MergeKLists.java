package com.luo.leetcode.list;

import com.luo.leetcode.collection.base.ListNode;

/**
 * 23. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author luoxiangnan
 * @date 2021-04-16
 */
public class MergeKLists {

    public static void main(String[] args) {
        System.out.println(new MergeKLists().mergeKLists(new ListNode[]{
                new ListNode(1, 4, 5),
                new ListNode(1, 3, 4),
                new ListNode(2, 6)
        }));

        System.out.println(new MergeKLists().mergeKLists(new ListNode[]{
                new ListNode(-2),
                new ListNode(-3, -2, 1)
        }));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (ListNode list : lists) {
            head = merge(head, list);
        }
        return head;
    }

    // 合并2个链表
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }

        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
