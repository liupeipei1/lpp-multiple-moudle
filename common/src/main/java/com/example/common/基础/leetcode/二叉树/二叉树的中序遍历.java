package com.example.common.基础.leetcode.二叉树;

import com.example.common.基础.leetcode.链表.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
遍历是从左 中 右
    1
      2
    3
    out= 1 3 2
 */
public class 二叉树的中序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer>  rs=inorderTraversal(root);
        for (Integer r : rs) {
            System.out.println(r);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      inorderTraversal(root,ans);
      return ans;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        inorderTraversal(root.left,ans);
        ans.add(root.val);
        inorderTraversal(root.right,ans);
    }
}
