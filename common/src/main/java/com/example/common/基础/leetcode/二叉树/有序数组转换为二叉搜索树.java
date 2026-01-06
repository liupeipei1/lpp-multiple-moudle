package com.example.common.基础.leetcode.二叉树;

import com.example.common.基础.leetcode.链表.TreeNode;

/*
  给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
注意：
1. 二叉搜索树（BST）性质
左子树的所有节点值 < 根节点值；
右子树的所有节点值 > 根节点值；
左右子树也必须是 BST。
任意节点的左右子树高度差的绝对值 ≤ 1

切记：因为二叉搜索树  的中序遍历就是升序  要求的是左边的节点永远小于右边的节点  从最左边 到中间再到右边
所以这里建立根节点一定是 取给的升序数组中中间的一个数
 */
public class 有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        TreeNode node = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
    /*
     中序遍历，总是选择中间位置左边的数字作为根节点
     对于整个中序遍历序列，下标范围从 left=0 到 right=nums.length−1。当 left>right 时，平衡二叉搜索树为空
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(0, nums.length - 1, nums);
    }
    /*
      将数组一分为二  左边的给left
      第一个节点是0
      第二个节点是-10
      第三个节点 -3
     */
    public static TreeNode helper(int left, int right, int[] nums) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1, nums);
        root.right = helper(mid + 1, right, nums);
        return root;
    }

}
