package com.nobug.experiment.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 07月 02日 17:58:00
 */
public class Title141 {
    public static boolean hasCycle (ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head.next;
        int count = 0;
        while (node1 != null && node2 != null && node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
            count++;
            if (node1 == node2) {
                System.out.println(count);
                return true;
            }
        }
        System.out.println(count);
        return false;
    }

    public static boolean hasCycleV2 (ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (!listNodeSet.add(node)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head1;
        System.out.println(hasCycleV2(head));
    }
}
