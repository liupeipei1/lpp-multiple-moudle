package com.example.common.基础.leetcode;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x
// 的深度尽可能大（一个节点也可以是它自己的祖先）。”
public class 二叉树的最近公共祖先 {

    private static TreeNode ans;

    二叉树的最近公共祖先() {
        this.ans = null;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);

        TreeNode p= new TreeNode(5);
        TreeNode q= new TreeNode(6);
        TreeNode rs = lowestCommonAncestor(node, p, q);
        System.out.println(rs);
    }

    public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) ||
                ((root.val == p.val || root.val == q.val) && (lson || rson))
        ) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    //1.递归的方法
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
         dfs(root, p, q);
        return ans;
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}