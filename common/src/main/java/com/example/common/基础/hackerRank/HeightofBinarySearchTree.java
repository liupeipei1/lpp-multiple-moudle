package com.example.common.基础.hackerRank;

import com.example.common.基础.leetcode.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Given the root of a binary search tree,
return the height of the tree. Height is the number of nodes along the longest path from root to leaf.
 */
public class HeightofBinarySearchTree {
    public static void main(String[] args) {
        Integer[] values = {4, 2, 6, 1, 3, 5, 7};
        Integer[] leftChild = {1, 3, 5, -1, -1, -1, -1};
        Integer[] rightChild = {2, 4, 6, -1, -1, -1, -1};
        int length = getBinarySearchTreeHeight(Arrays.asList(values), Arrays.asList(leftChild), Arrays.asList(rightChild));
        System.out.printf("length=%d", length);
    }

    public static int getBinarySearchTreeHeight(List<Integer> values, List<Integer> leftChild, List<Integer> rightChild) {
        // Write your code here
        // 1. 处理空树情况
        if (values == null || values.isEmpty()) {
            return 0;
        }
        //assemble the tree node
        // 2. 找到根节点索引（未出现在leftChild和rightChild中的索引）
        //int rootIdx = getRootIdx(values, leftChild, rightChild);
        int rootIdx = -1;
        int size = values.size();
        List<Integer> a = leftChild.stream().filter(p -> p != -1).collect(Collectors.toList());
        List<Integer> b = rightChild.stream().filter(p -> p != -1).toList();
        for (int i = 0; i < size; i++) {
            if (a.contains(i) || b.contains(i)) {
                continue;
            }
            rootIdx = i;
        }
        // 空树（无有效根节点）
        if (rootIdx == -1) {
            return 0;
        }
        // 空树（无有效根节点）
        // 3. 递归构建二叉树
        TreeNode root = buildTree(rootIdx, values, leftChild, rightChild);
        //calculate the heigh of node
        return maxDepth(root);
    }

    private static int getRootIdx(List<Integer> values, List<Integer> leftChild, List<Integer> rightChild) {
        int n = values.size();
        boolean[] isChild = new boolean[n];
        for (int idx : leftChild) {
            if (idx != -1) { // -1表示无左子节点
                isChild[idx] = true;
            }
        }
        for (int idx : rightChild) {
            if (idx != -1) { // -1表示无右子节点
                isChild[idx] = true;
            }
        }

        int rootIdx = -1;
        for (int i = 0; i < n; i++) {
            if (!isChild[i]) {
                rootIdx = i;
                break;
            }
        }
        return rootIdx;
    }

    // 递归构建二叉树  这里的idx会根据第一次idx传入然后获取当前左右数的index
    public static TreeNode buildTree(int idx, List<Integer> values, List<Integer> leftChild, List<Integer> rightChild) {
        if (idx == -1) {
            return null;
        }
        TreeNode node = new TreeNode(values.get(idx));
        node.left = buildTree(leftChild.get(idx), values, leftChild, rightChild);
        node.right = buildTree(rightChild.get(idx), values, leftChild, rightChild);
        return node;
    }

    //node的深度 最基本的
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
