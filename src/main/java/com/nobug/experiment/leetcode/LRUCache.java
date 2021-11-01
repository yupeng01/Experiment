package com.nobug.experiment.leetcode;

public class LRUNode {
    public LRUNode prev;
    public LRUNode next;
    public int val;

    public LRUNode () {

    }

    public LRUNode (int value) {
        this.val = value;
    }
}
