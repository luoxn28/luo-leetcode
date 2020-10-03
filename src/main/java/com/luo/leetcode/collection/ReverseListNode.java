package com.luo.leetcode.collection;

import com.luo.leetcode.collection.base.ListNode;

/**
 * 翻转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author luoxiangnan
 * @date 2020-10-03
 */
public class ReverseListNode {

    public static void main(String[] args) {

        {
            ListNode head = new ListNode(1);
            head.next(2).next(3).next(4).next(5);
            System.out.println(head);
            System.out.println(new ReverseListNode().reverseList(head));
        }
        {
            ListNode head = new ListNode(1);
            head.next(2).next(3).next(4).next(5);

            System.out.println("\n" + head);
            System.out.println(new ReverseListNode().reverseN(head, 3));
        }
        {
            ListNode head = new ListNode(1);
            head.next(2).next(3).next(4).next(5);

            System.out.println("\n" + head);
            System.out.println(new ReverseListNode().reverseBetween(head, 2, 4));
        }
    }

    /**
     * 递归翻转链表
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 后驱节点
    ListNode successor = null;

    /**
     * 反转以 head 为起点的 n 个节点，返回新的头结点
     */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    /**
     * 翻转某个区间的节点，第一个节点位置为1
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
