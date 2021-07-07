package com.nobug.experiment.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 07月 06日 19:37:00
 */
public class Title160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        Set<ListNode> set = new HashSet();
        while (node1 != null || node2 != null) {
            if (node1 != null && !set.add(node1)) {
                return node1;
            }
            if (node2 != null && !set.add(node2)) {
                return node2;
            }
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(8);
        ListNode listNode7 = new ListNode(4);
        ListNode listNode8 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(getIntersectionNode(listNode1, listNode3).val);
    }
}
