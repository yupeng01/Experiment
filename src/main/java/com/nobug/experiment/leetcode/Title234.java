package com.nobug.experiment.leetcode;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 回文链表
 * @createTime 2021年 07月 08日 16:16:00
 */
public class Title234 {
    public static ListNode frontNode;
    public static boolean recursivelyCheck (ListNode node) {
        if (node != null) {
            if (!recursivelyCheck(node.next)) {
                return false;
            }
            if (node.val != frontNode.val) {
                return false;
            }
            frontNode = frontNode.next;
        }
        return true;
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        frontNode = head;
        return recursivelyCheck(head);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(isPalindrome(listNode1));
    }
}
