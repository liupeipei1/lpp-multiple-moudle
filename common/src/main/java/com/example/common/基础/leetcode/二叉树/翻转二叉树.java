package com.example.common.基础.leetcode.二叉树;

import com.example.common.基础.leetcode.链表.TreeNode;

/*
 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class 翻转二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        TreeNode treeNode = invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
