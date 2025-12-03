package com.example.common.基础.leetcode;

import java.util.*;

/*
 给你二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
注意：先序遍历
先序遍历：访问根节点 → 递归左子树 → 递归右子树
     1
  2    5
3  4     6
-》 1 2 3 4 5 6
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
 */
public class 二叉树展开为链表 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);


        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(5);
        flatten(root);

    }

    //先序遍历  访问根节点 → 递归左子树 → 递归右子树
    //这里的list存储了所有nodes的接点 按照中左右的顺序 先将左边节点 所有的添加去其次再添加左边节点肯呢个存在的右边节点
    //其次再添加根节点的右边分支-左边分支然后再试右边分支
    public static void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        preOderTraversal(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);  //pre-1   curr=2  pre=2 curr=3
            prev.left = null;
            prev.right = curr;
        }
    }

    /*
    按照题目要求的先序排列  中-左-右
     */
    public static void preOderTraversal(TreeNode root, List<TreeNode> ans) {
        if (root == null) return;
        ans.add(root);
        preOderTraversal(root.left, ans);
        preOderTraversal(root.right, ans);
    }


}

