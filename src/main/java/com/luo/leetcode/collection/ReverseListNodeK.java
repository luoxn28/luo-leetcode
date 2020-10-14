package com.luo.leetcode.collection;

import com.luo.leetcode.collection.base.ListNode;

/**
 * @author luoxiangnan
 * @date 2020-10-14
 */
public class ReverseListNodeK {

    public static void main(String[] args) {
        {
            ListNode head = new ListNode(1);
            head.next(2).next(3).next(4).next(5);
            System.out.println(new ReverseListNodeK().reverseKGroup(head, 2));
        }

        {
            ListNode head = new ListNode(1);
            head.next(2).next(3).next(4).next(5);
            System.out.println(new ReverseListNodeK().reverseKGroup(head, 3));
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }

        ListNode newHead = reverse(head, cur);
        head.next = reverseKGroup(cur, k);
        return newHead;
    }

    /**
     * 反转区间[head, end)
     */
    private ListNode reverse(ListNode head, ListNode end) {
        if (end == head) {
            return head;
        }

        ListNode prev = null, cur = head;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
