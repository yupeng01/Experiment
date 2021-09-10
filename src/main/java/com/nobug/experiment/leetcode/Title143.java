package com.nobug.experiment.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Objects;

public class Title143 {
    public static void reorderList(ListNode head) {
        ListNode middleHeadNode = findMiddleNode (head);
        ListNode reverseHeadNode = reverseListNode (middleHeadNode);
        mergeTwoList (head, reverseHeadNode);
    }

    public static ListNode findMiddleNode (final ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (Objects.nonNull(fastNode.next) && Objects.nonNull(fastNode.next.next)) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        if (fastNode.next != null) {
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static ListNode reverseListNode (final ListNode head) {
        ListNode prev = null;
        ListNode head2 = head;
        while (head2 != null) {
            ListNode node = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = node;
        }
        return prev;
    }

    public static void mergeTwoList (final ListNode l1, ListNode l2) {
        ListNode node = l1;
        while (l2 != null) {
            ListNode nextNode = node.next;
            ListNode nextL2 = l2.next;
            node.next = l2;
            l2.next = nextNode;
            if (nextL2 == null) {
                l2.next = null;
            }
            l2 = nextL2;
            node = nextNode;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        reorderList(listNode);
        System.out.println(JSON.toJSONString(listNode));
    }
}
