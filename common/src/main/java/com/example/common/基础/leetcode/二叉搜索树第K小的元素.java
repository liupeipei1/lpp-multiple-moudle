package com.example.common.基础.leetcode;

import java.util.*;

/*
 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 输入：root = [3,1,4,null,2], k = 1
输出：1
    3
 1    4
  2
  如果是中序遍历结果就是最终中序遍历的结果是：1 → 2 → 3 → 4。
  中序遍历的规则是「左子树 → 根节点 → 右子树」，遍历过程如下：
 */
public class 二叉搜索树第K小的元素 {
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        System.out.printf("" + kthSmallest(treeNode, 1));

        System.out.printf("\n" + kthSmallest1(treeNode, 1));

        System.out.printf("\n" + kthSmallest2(treeNode, 2));

    }

    /*
     方法1：队列+ 中序遍历
     因为先进先出 所以会按照 二叉树的层级从上到下  最后需要排序下即可
     */
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        List<Integer> r = new ArrayList<>();
        dfs1(root, r);
        Collections.sort(r);
        return r.get(k - 1);
    }

    /*
        方法2：递归+ 中序遍历   左中右  这样就是保证返回的数组是从小到大
      */
    public static int kthSmallest1(TreeNode root, int k) {
        if (root == null) return 0;
        dfs(root);
        return result.get(k - 1);
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
    }


    public static void dfs1(TreeNode root, List<Integer> r) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //队列进去 然后遍历当前的值添加到list
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                r.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }

    /*
     栈的方式  先进后出  中序遍历的方式
     */
    public static int kthSmallest2(TreeNode root, int k) {
        if (root == null) return 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return root.val;
    }
}
