package com.example.common.基础.leetcode;
/*
二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */

public class 二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.printf("length: %d\n",maxDepth(root));
    }
    /*
       case:
            3
        9      20
            15     7
      第一个9 的深度 1
      第二个20 的深度 -》 15（深度1）  7的深度1-》 1+1的深度
     */

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
