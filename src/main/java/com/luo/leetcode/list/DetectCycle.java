package com.luo.leetcode.list;

import com.luo.leetcode.collection.base.ListNode;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author luoxiangnan
 * @date 2021-04-16
 */
public class DetectCycle {

    public static void main(String[] args) {
        {
            ListNode head = new ListNode(3);
            ListNode node2 = new ListNode(2);
            head.next = node2;
            node2.next(0).next(-4).next = node2;

            System.out.println(new DetectCycle().detectCycle(head).val);
        }

        {
            ListNode head = new ListNode(1);
            ListNode node2 = new ListNode(2);
            head.next = node2;
            node2.next = head;

            System.out.println(new DetectCycle().detectCycle(head).val);
        }

        {
            ListNode head = new ListNode(1);
            System.out.println(new DetectCycle().detectCycle(head));
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        if (fast == null || fast.next == null) {
            return null;
        }

        do {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return null;
            }
        } while (fast != slow);

        // slow继续往下走，走到head和slow相遇时就是环的起点
        while (head != slow) {
            slow = slow.next;
            head = head.next;
        }
        return head;
    }
}
