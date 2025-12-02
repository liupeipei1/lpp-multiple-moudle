package com.example.common.基础.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

 */
public class 二叉树的右视图 {
    static List<List<Integer>> lists = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> list = rightSideView(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d ", list.get(i));
        }

        List<Integer> list1 = rightSideView1(root);
        for (int i = 0; i < list1.size(); i++) {
            System.out.printf("%d ", list1.get(i));
        }
    }

    //利用二叉树的层级遍历 将每一个层级的元素记录
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 1);
        for (List<Integer> list1 : lists) {
            if (list1 != null) {
                list.add(list1.get(list1.size() - 1));
            }
        }
        return list;
    }

    public static void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (lists.size() < index) {
            lists.add(new ArrayList<>());
        }
        dfs(root.left, index + 1);
        lists.get(index - 1).add(root.val);
        dfs(root.right, index + 1);
    }



    //solution 2
    public static List<Integer> rightSideView1(TreeNode root) {
        findPro(root, 0);
        return result;
    }
    /*
      二叉树的右视图要求显示每一层最右侧的节点，这段代码通过优先遍历右子树的方式，
      确保每一层第一个被访问到的节点就是最右侧节点，因此需要先递归右子树再递归左子树。
      */
    private static void findPro(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(node.val);
        }
        findPro(node.right, depth + 1);
        findPro(node.left, depth + 1);
    }
}
