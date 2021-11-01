package com.nobug.experiment.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class LRUNode {
        LRUNode prev;
        LRUNode next;
        int val;
        public LRUNode () {}
        public LRUNode (int val) {
            this.val = val;
        }
    }

    LRUNode dummyHead = new LRUNode();
    LRUNode dummyTail = new LRUNode();
    int length = 0;
    int cap;
    Map<Integer, LRUNode> map = new HashMap();

    public LRUCache(int capacity) {
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.cap = capacity;
    }

    public int get(int key) {
        LRUNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        modifyNodeToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        LRUNode node = map.get(key);
        if (node == null) {
            map.put(key, new LRUNode(value));
            addNodeToHead(new LRUNode(value));
            length++;
            if (length > cap) {
                removeTail();
            }
            return;
        }
        node.val = value;
        modifyNodeToHead(node);
    }

    public void addNodeToHead (LRUNode node) {
        LRUNode next = dummyHead.next;
        node.next = next;
        dummyHead.next = node;
        node.prev = dummyHead;
    }

    public void modifyNodeToHead (LRUNode node) {
        LRUNode prev = node.prev;
        LRUNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
    }

    public void removeTail () {
        LRUNode tail = dummyTail.prev;
        LRUNode prev = tail.prev;
        prev.next = dummyTail;
        dummyTail.prev = prev;
        tail.next = null;
        tail.prev = null;
    }
}
