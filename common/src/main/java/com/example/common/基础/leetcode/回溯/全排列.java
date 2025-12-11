package com.example.common.基础.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class 全排列 {

    public static void main(String[] args) {
        List<List<Integer>> rs = permute(new int[]{1, 2, 3});
        for (List<Integer> r : rs) {
            //   System.out.println(r);
        }
        List<List<Integer>> rs1 = permute1(new int[]{1, 2});
        for (List<Integer> r : rs1) {
            System.out.println(r);
        }

        List<List<Integer>> rs2 = permute3(new int[]{1, 2,3});
        for (List<Integer> r : rs2) {
            System.out.println(r);
        }
    }

    //回溯法1 可以解决
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, nums, 0);
        return result;
    }

    //也是可以解决的
    public static List<List<Integer>> permute1(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        int[] path = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        dfs1(result, path, nums, visited, 0);
        return result;
    }

    /*
     示例 1：
    输入：nums = [1,2,3]
    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static void dfs(List<List<Integer>> rs, List<Integer> path, int[] nums, int index) {
        if (index == nums.length) {
            // 关键：添加path的副本，而非引用
            rs.add(new ArrayList<>(path));//递归终止时，path 的内容是一个完整排列，通过 new ArrayList<>(path) 创建副本并加入 rs，避免后续修改 path 影响已保存的结果。
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!path.contains(nums[i])) {
                    path.add(nums[i]);
                    dfs(rs, path, nums, index + 1);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    /**
     * 用标记符号
     * 当nums[1,2]
     * 外层i=0  index=0  第一次选 1 后，used[0]=true
     * 递归选 2 生成 [1,2]   当index=2 也就是第三次递归的时候 i=1 然后将最后一个设置i的位置设置 false 然后i-1位置设置 false
     * 然后重新外层i=1 第二次外部循环
     */
    public static void dfs1(List<List<Integer>> rs, int[] path, int[] nums, boolean[] used, int index) {
        // 终止条件：path所有位置都填充完成
        if (index == nums.length) {
            // 把int[]转为List存入结果（避免引用问题）
            List<Integer> r = new ArrayList<>();
            for (int i : path) {
                r.add(i);
            }
            rs.add(new ArrayList<>(r));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    path[index] = nums[i];
                    used[i] = true;
                    dfs1(rs, path, nums, used, index + 1);
                    // 3. 回溯：撤销选择（核心！必须恢复状态）
                    // 注：path[index]无需显式重置——因为下一次循环会直接覆盖这个位置的值
                    // 但“used[i]的重置”是必须的回溯操作！
                    used[i] = false;
                }
            }
        }
    }

    //solution3
    static List<List<Integer>> ans;
    static int n;
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*
      [1,2,3]
      k=1  i=0的时候   1位置不变  需要交换第1位和第二位 存在123 132

     */
    private static void dfs3(int[] nums, int i) {
        if (i == n-1) {
            List<Integer> list = new ArrayList<>();
            for (int a : nums)
                list.add(a);
            ans.add(list);
            return;
        }
        for (int k=i; k<n; k++) {
            swap(nums, i, k);// 选择：将第k个元素放到第i个位置
            dfs3(nums, i+1); // 递归：确定下一个位置（i+1）的元素
            swap(nums, i, k);// 回溯：恢复交换，回到选择前的状态
        }
    }

    public static List<List<Integer>> permute3(int[] nums) {
        ans = new ArrayList<>();
        n = nums.length;
        dfs3(nums, 0);
        return ans;
    }
}
