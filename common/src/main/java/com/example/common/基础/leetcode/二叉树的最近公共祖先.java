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

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(6);
        TreeNode rs = lowestCommonAncestor(node, p, q);
        System.out.println(rs);
    }

    /*
     通过 DFS（后序遍历）寻找二叉树中两个节点 p、q 的最近公共祖先（LCA） 的核心实现
     核心逻辑是利用递归的返回值标记 “子树中是否包含 p/q”
     场景 1：left && right → p 和 q 分别在当前节点的左右子树
    - 说明当前节点是 p 和 q 的 “分叉点”，且是最深的分叉点（后序遍历先查子树，所以先找到的分叉点就是最近的）；
    - 例子：p=5、q=1，遍历到 root=3 时，left（左子树有 5）=true，right（右子树有 1）=true → 3 是 LCA。
    场景 2：(root是p/q) && (left/right有另一个节点) → 当前节点是 p/q，且另一个节点在其子树中
    - 说明当前节点就是 LCA（因为另一个节点在它的子树里，它自己是 p/q，自然是最近的祖先）；
    - 例子：p=5、q=4，遍历到 root=5 时，root.val=5（是 p），且 right（右子树有 4）=true → 5 是 LCA。
     */

    public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 递归终止条件：空节点不可能包含p/q，返回false
        if (root == null) {
            return false;
        }
        // 2. 后序遍历：先递归查找左、右子树是否包含p/q
        // left = 左子树是否有p或q；right = 右子树是否有p或q
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        // 3. 核心条件：判断当前root是否是p/q的最近公共祖先
        if ((lson && rson) ||
                ((root.val == p.val || root.val == q.val) && (lson || rson))
        ) {
            ans = root;
        }
        // 4. 返回值：当前子树（以root为根）是否包含p或q
        /*
        - left：左子树有 p/q → 当前子树有；
        - right：右子树有 p/q → 当前子树有；
        - root.val == p/q.val：当前节点就是 p/q → 当前子树有；
        - 只要满足一个，就返回 true，告诉父节点 “我这个子树里有 p/q”。
         */
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