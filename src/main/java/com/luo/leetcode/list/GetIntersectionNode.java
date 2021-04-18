package com.luo.leetcode.list;

import com.luo.leetcode.collection.base.ListNode;

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author luoxiangnan
 * @date 2021-04-16
 */
public class GetIntersectionNode {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 将两个链表剪成长度一致
        int la = lenListNode(headA);
        int lb = lenListNode(headB);
        if (la > lb) {
            while (la-- > lb) {
                headA = headA.next;
            }
        } else if (lb > la) {
            while (lb-- > la) {
                headB = headB.next;
            }
        }

        return doGetIntersectionNode(headA, headB);
    }

    public ListNode doGetIntersectionNode(ListNode headA, ListNode headB) {
        return headA == headB ? headA : doGetIntersectionNode(headA.next, headB.next);
    }

    // 链表长度
    public int lenListNode(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
