package com.example.common.基础.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
 */
public class 路径总和 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);


        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(1);
        root1.right.right.left = new TreeNode(5);
        System.out.printf("" + pathSum(root1, 22));

    }

    //solution 前缀和
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Long, Integer> prefix = new HashMap<>();//prefix：哈希表，记录从根到当前路径上的前缀和及其出现次数（键 = 前缀和，值 = 出现次数）；
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    /*
      深度搜索 + 前缀和 + 回溯
      通过深度优先搜索（DFS）结合前缀和思想，统计二叉树中路径和等于目标值targetSum的路径数量的核心实现。
      路径定义为 “从任意节点到其后代节点的连续路径”
      回溯：递归遍历完子树后，需从prefix中移除当前节点的前缀和（避免影响其他分支的统计）

    curr - targetSum 其实是在找一个 “历史前缀和”：
    假设二叉树路径是：根(1) → A(2) → B(3) → C(4)，targetSum=7。
    到节点 C 时，curr = 1+2+3+4 = 10；
    计算 curr - targetSum = 10 - 7 = 3；
    我们去哈希表中查是否有前缀和等于3：发现 “根→A” 的前缀和正好是1+2=3；
    这就说明：从 A 的下一个节点（B）到 C 的路径和（3+4=7）等于targetSum！

    处理当前节点（计算curr、更新prefix）
    2. 递归遍历左子树
    3. 递归遍历右子树
    4. 回溯当前节点的prefix（减1）
     */
    public static int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int let = 0;// 记录当前节点及子树中符合条件的路径数
        curr = curr + root.val;
        let = prefix.getOrDefault(curr - targetSum, 0);//统计以当前节点为终点的符合条件路径数
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        let += dfs(root.left, prefix, curr, targetSum);
        let += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);//回溯
        return let;
    }
}
