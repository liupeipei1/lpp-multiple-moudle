package com.example.common.基础.leetcode;

public class 二叉树直径 {
    static int ans = 1;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.printf("" + diameterOfBinaryTree(treeNode));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;

    }

    public static int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);// 左儿子为根的子树的深度
        int right = depth(root.right);// 右儿子为根的子树的深度
        ans = Math.max(ans, left+right+1);// 计算d_node即L+R+1 并更新ans
        return Math.max(left, right) + 1;// 返回该节点为根的子树的深度
    }
}
