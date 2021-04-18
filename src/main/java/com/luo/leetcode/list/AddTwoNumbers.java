package com.luo.leetcode.list;

import com.luo.leetcode.collection.base.ListNode;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author luoxiangnan
 * @date 2021-04-16
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        System.out.println(new AddTwoNumbers().addTwoNumbers(new ListNode(2, 4, 3), new ListNode(5, 4, 6)));
        System.out.println(new AddTwoNumbers().addTwoNumbers(new ListNode(0), new ListNode(0)));
        System.out.println(new AddTwoNumbers().addTwoNumbers(new ListNode(9, 9, 9, 9, 9, 9, 9), new ListNode(9, 9, 9, 9)));
    }

    /**
     * 两个链表相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;

        // 两数相加
        int add = 0;
        while (l1 != null || l2 != null) {
            int sum = add
                    + (l1 != null ? l1.val : 0)
                    + (l2 != null ? l2.val : 0);
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            add = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (add > 0) {
            tail.next = new ListNode(add);
        }
        return head;
    }
}
