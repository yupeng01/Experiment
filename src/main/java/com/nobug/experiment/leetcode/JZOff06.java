package com.nobug.experiment.leetcode;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 从尾到头打印链表
 * @createTime 2021年 07月 15日 13:59:00
 */
public class JZOff06 {
    public static int count = 0;
    public static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0;i < arr.length; i++) {
            arr[i] = list.get(list.size() - 1 - i);
        }
        return arr;
    }

    public static int[] reversePrintV2 (ListNode head) {
        ListNode listNode = reverseList(head);
        int[] arr = new int[count];
        for (int i = 0;i < count; i++) {
            arr[i] = listNode.val;
            listNode = listNode.next;
        }
        return arr;
    }

    public static int[] reversePrintV3 (ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        int[] arr = new int[deque.size()];
        for (int i = 0;i < arr.length; i++) {
            arr[i] = deque.pop();
        }
        return arr;
    }

    public static ListNode reverseList (ListNode head) {
        ListNode curr = head;
        head = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = head;
            head = curr;
            curr = next;
            count++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        Gson gson = new Gson();
        System.out.println(gson.toJson(reversePrintV2(listNode)));
    }
}
