package com.example.common.基础.leetcode.二叉树;

import com.example.common.基础.leetcode.链表.TreeNode;

/*
二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。

核心点：计算当前节点的 最大路径和 可以包含左右节点，但最大贡献度不能同时包括左右节点。
因为对于某节点，他的贡献只能带其中一个孩子（带大孩子走），整个路径才能向上延伸
 */
public class 二叉树中的最大路径和 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        maxGain(root);
        System.out.printf("" + maxSum);
    }

    static int maxSum = Integer.MIN_VALUE;
    /*
    「当前节点的最大贡献值」 和 「以当前节点为顶点的路径和」，代码本质是通过后序遍历，一边计算 “贡献值”，一边更新全局最大路径和。
    return 的部分是「当前节点能给父节点提供的最大贡献值」（只能选左 / 右一条路往上走）
    priceNewPath 是「以当前节点为顶点的完整路径和」（左右都能走，是当前节点能形成的最大路径）
    maxSum 是全局变量，记录遍历过程中所有节点的「完整路径和」的最大值。
    父节点只能从当前节点的左 / 右选一条路往下走（路径是连续的，不能分叉），
    所以当前节点能给父节点的最大贡献值 = 当前节点的钱 + max(左子树能给的分红, 右子树能给的分红)。
     */
    public static int maxGain(TreeNode node) {
        // 1. 递归终止：空节点没有贡献值，返回0（没钱可分）
        if (node == null) return 0;
        //2. 后序遍历：先算左、右子树的贡献值（先让子节点算分红）
        int leftGain = Math.max(0,maxGain(node.left));
        int rightGain = Math.max(0,maxGain(node.right));
        // 3. 计算「自己当老板」的总收益（左右都要，形成完整路径）
        int priceNewPath =  node.val + leftGain + rightGain;
        // 4. 更新全局最大：当前总收益是否比之前的maxSum更大
        maxSum = Math.max(priceNewPath, maxSum);
        // 5. 计算「给父节点的分红」：只能选左/右一条路，负数就选0（不亏钱）
        return node.val + Math.max(leftGain, rightGain); //最大贡献值 要想能往上走 必须当前节点只能走一个子树
    }

}
