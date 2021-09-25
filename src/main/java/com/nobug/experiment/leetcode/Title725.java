package com.nobug.experiment.leetcode;

import com.alibaba.fastjson.JSON;

public class Title725 {

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        int num = length / k;
        int moreNum = length % k;
        String s = "";

        ListNode[] result = new ListNode[k];
        curr = head;
        if ((num == 1 && moreNum == 0) || num == 0) {
            for (int i = 0; i < k; i++) {
                if (curr != null) {
                    ListNode newNode = curr;
                    curr = curr.next;
                    newNode.next = null;
                    result[i] = newNode;
                } else {
                    result[i] = null;
                }
            }
            return result;
        }
        for (int i = 0; i < k; i++) {
            int moreLength = num;
            if (moreNum >= i + 1) {
                moreLength = num + 1;
            }
            ListNode newNode = curr;
            ListNode newCurr = newNode;
            for (int j = 0; j < moreLength; j++) {
                if (j == moreLength - 1) {
                    newCurr = curr;
                }
                curr = curr.next;
            }
            newCurr.next = null;
            result[i] = newNode;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{0, 1, 2});

        System.out.println(JSON.toJSONString(splitListToParts(head, 2)));
    }
}
