package com.luo.leetcode.collection;

import com.luo.leetcode.collection.base.ListNode;

/**
 * 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author luoxiangnan
 * @date 2020-10-10
 */
public class ListDetectCycle {

    public static void main(String[] args) {
        {
            ListNode head = new ListNode(3);
            ListNode node2 = new ListNode(2);
            head.next = node2;
            node2.next(0).next(-4).next = node2;

            System.out.println(new ListDetectCycle().detectCycle(head).val);
        }

        {
            ListNode head = new ListNode(1);
            ListNode node2 = new ListNode(2);
            head.next = node2;
            node2.next = head;

            System.out.println(new ListDetectCycle().detectCycle(head).val);
        }

        {
            ListNode head = new ListNode(1);
            System.out.println(new ListDetectCycle().detectCycle(head));
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        // 汇合点为slow，让fast从汇合点开始走，让slow还从head开始走，这次二者速度一直，那么再次汇合点就是环的交汇点
        fast = slow.next;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 检测是否存在环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;

        }
        return true;
    }
}
