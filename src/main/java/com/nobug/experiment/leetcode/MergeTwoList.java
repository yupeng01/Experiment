package com.nobug.experiment.leetcode;

import com.alibaba.fastjson.JSON;

public class MergeTwoList {

    public static void doMerge (final ListNode list1, ListNode l2) {
        ListNode l1 = list1;
        while (l2 != null) {
            ListNode nextL1 = l1.next;
            ListNode nextL2 = l2.next;
            l1.next = l2;
            l2.next = nextL1;
            if (nextL2 == null) {
                l2.next = null;
            }
            l1 = nextL1;
            l2 = nextL2;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(3);
        doMerge(l1, l2);
        System.out.println(JSON.toJSONString(l1));
    }
}
