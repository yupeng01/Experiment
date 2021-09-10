package com.nobug.experiment.leetcode;

public class Title92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) {
            return head;
        }
        ListNode node = head;
        int count = 0;
        ListNode leftNode = null;
        ListNode leftLastNode = null;
        ListNode leftNextNode = null;
        ListNode rightNode = null;
        ListNode rightLastNode = null;
        ListNode rightNextNode = null;
        while (node != null) {
            count++;
            if (count + 1 == left) {
                leftLastNode = node;
            }
            if (count == left) {
                leftNode = node;
                leftNextNode = node.next;
            }
            if (count + 1 == right) {
                rightLastNode = node;
            }
            if (count == right) {
                rightNode = node;
                rightNextNode = node.next;
                break;
            }
            node = node.next;
        }
        leftLastNode.next = rightNode;
        rightNode.next = leftNextNode;

        rightLastNode.next = leftNode;
        leftNode.next = rightNextNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(reverseBetween(listNode, 2, 4));
        System.out.println("");
    }
}
