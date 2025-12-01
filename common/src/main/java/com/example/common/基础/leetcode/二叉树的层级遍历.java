package com.example.common.基础.leetcode;

import java.util.*;

/*
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
 */
public class 二叉树的层级遍历 {
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<List<Integer>> r = levelOrder1(treeNode);
        for (List<Integer> list : r) {
            list.forEach(System.out::println);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 1);
        return list;
    }

    /*
     solution1 递归的方式  中序的方式左中右    index第几层
     */
    public static void dfs(TreeNode root, int index) {
        if (root == null) return;//跳出递归条件
        if (list.size() < index) {
            list.add(new ArrayList<Integer>());
        }
        dfs(root.left, index + 1);
        list.get(index - 1).add(root.val);
        dfs(root.right, index + 1);
    }


    /*solution 2
       队列的方式 先进先出
       元素从队尾（tail）入队（offer()/add()），从队头（head）出队（poll()/remove()）；
       LinkedList 是双向链表结构，作为 Queue 的实现类，相比其他队列（如 ArrayDeque）有以下特点：
       支持从队头入队（addFirst()/offerFirst()）、队尾出队（removeLast()/pollLast()）等；
     */
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//or offer
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();//or remove
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }

}
