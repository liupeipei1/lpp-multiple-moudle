package com.example.common.基础.leetcode.二叉树;

import com.example.common.基础.leetcode.链表.TreeNode;

/*
 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 严格小于 当前节点的数。
节点的右子树只包含 严格大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

[5,4,6,null,null,3,7]  不属于二叉查找树
右子树（节点6及其子节点）必须所有值 > 5，但节点3的值 3 < 5，因此违反了 BST 的性质。
 */
public class 验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);


        TreeNode treeNode1 = new TreeNode(5);
        treeNode1.left = new TreeNode(4);
        treeNode1.right = new TreeNode(6);
        treeNode1.right.left = new TreeNode(3);
        treeNode1.right.right = new TreeNode(7);
        System.out.printf("" + isValidBST(treeNode1));
    }


    public static boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }

    //递归
    public static boolean check(TreeNode head, long min, long max) {
        if (head == null) return true;
        if(head.val<= min || head.val>= max) return false;
        return check(head.left,min,head.val) && check(head.right,head.val,max);
    }
}
