package com.example.common.基础.leetcode;

import com.github.andrewoma.dexx.collection.internal.redblack.Tree;

import java.util.Arrays;

/*
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
 */
public class 从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        buildTree1(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    /*
     先序 根左右
       [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
       中序是 左中右
       [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
        输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        输出: [3,9,20,null,null,15,7]  这个比较容易理解点
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode node = new TreeNode(preorder[0]);
        if (preorder.length == 1) return node;
        //找到 中序的左边节点 和右边节点
        int index = 0;
        while (index < inorder.length) {
            if (inorder[index] == preorder[0]) {
                break;
            }
            index++;
        }
        if (index != 0) {
            node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),//相当于根节点左边的长度
                    Arrays.copyOfRange(inorder, 0, index));
        }
        if (index != inorder.length - 1) {
            node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                    Arrays.copyOfRange(inorder, index + 1, inorder.length));
        }
        return node;
    }


    static int pre; //记录先序遍历的当前索引
    static int in;//记录中序遍历的当前索引

    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        return help(preorder, inorder, Integer.MAX_VALUE);
    }

    public static TreeNode help(int[] preorder, int[] inorder, int stop) {
        if (pre == preorder.length) {//先序遍历结束
            return null;
        }
        if (inorder[in] == stop) {//stop是当前子树在中序遍历中的右边界值（即父节点值） stop第一次等于根节点 可以知道右边数的开始
            in++;
            return null;
        }
        int val = preorder[pre++];//这里先得到pre下标的值 然后再++
        TreeNode root = new TreeNode(val);
        root.left = help(preorder, inorder, val);
        root.right = help(preorder, inorder, stop);
        return root;
    }
}
