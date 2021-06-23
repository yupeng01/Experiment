package com.nobug.experiment.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 反转链表
 * @createTime 2021年 06月 16日 19:16:00
 */
public class JZOff24 {
    public static ListNode reverseList (ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(JSON.toJSONString(reverseList(head)));
    }
}
