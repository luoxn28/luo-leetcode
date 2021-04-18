package com.luo.leetcode.list;

import com.luo.leetcode.collection.base.ListNode;

/**
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author luoxiangnan
 * @date 2021-04-16
 */
public class SortList {

    public static void main(String[] args) {
        System.out.println(new SortList().sortList(new ListNode(4, 2, 1, 3)));
        System.out.println(new SortList().sortList(new ListNode(-1, 5, 3, 4, 0)));
        System.out.println(new SortList().sortList(null));
    }

    public ListNode sortList(ListNode head) {
        return partition(head, null);
    }

    // 分治法，先切分为小的链表，然后合并成大的链表
    public ListNode partition(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        } else if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode l1 = partition(head, slow);
        ListNode l2 = partition(slow, tail);
        return merge(l1, l2);
    }

    // 合并2个链表
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);

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
