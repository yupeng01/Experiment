package com.nobug.experiment.leetcode;

import com.alibaba.fastjson.JSON;

public class Title92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private static void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public static ListNode reverseBetweenV2 (ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode subHead = null;
        ListNode subHeadPrev = null;
        ListNode subHeadPrevNext = null;
        ListNode curr = dummyHead;

        int count = 0;
        while (curr != null) {
            if (count + 1 == left) {
                subHeadPrev = curr;
                subHead = curr.next;
                subHeadPrevNext = curr.next;
            }
            if (count > left) {
                subHead.next = curr.next;
                subHeadPrev.next = curr;
                curr.next = subHeadPrevNext;
                subHeadPrevNext = curr;
                curr = subHead.next;
            } else {
                curr = curr.next;
            }
            if (count == right) {
                break;
            }
            count++;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.println(JSON.toJSONString(reverseBetweenV2(listNode, 2, 4)));
    }
}
