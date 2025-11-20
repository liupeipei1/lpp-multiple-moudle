package com.example.common.基础.leetcode;

public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode rs= lowestCommonAncestor(null,null,null);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}