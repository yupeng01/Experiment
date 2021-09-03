package com.nobug.experiment.leetcode;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 08日 19:40:00
 */
public class Title101 {
    public static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public static boolean check (TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        }
        return leftNode.val == rightNode.val && check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
//                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
//        System.out.println(isSymmetric(treeNode));
//
//        TreeNode treeNode2 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
//                new TreeNode(2, new TreeNode(3), new TreeNode(3)));
//        System.out.println(isSymmetric(treeNode2));
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = null;
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = null;
        treeNode.right.right = new TreeNode(3);
        System.out.println(isSymmetricV2(treeNode));
    }

    public static boolean isSymmetricV2(TreeNode root) {
        return isSymmetricV2(root.left, root.right);
    }

    public static boolean isSymmetricV2(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricV2(left.left, right.right) && isSymmetricV2(left.right, right.left);
    }
}
