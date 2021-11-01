package com.nobug.experiment.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {

    public static List<Integer> sort(TreeNode root) {
        List<Integer> inorderList = new ArrayList();
        Deque<TreeNode> stack = new LinkedList();
        while (!stack.isEmpty() || root != null) {
            TreeNode node = root;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.poll();
            inorderList.add(node.val);
            node = node.right;
        }
        return inorderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(sort(root));
    }
}
