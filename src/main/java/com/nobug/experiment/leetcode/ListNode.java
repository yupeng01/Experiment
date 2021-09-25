package com.nobug.experiment.leetcode;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 16日 19:16:00
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode (int[] arr) {
        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        this.val = dummyNode.next.val;
        this.next = dummyNode.next.next;
    }
}
