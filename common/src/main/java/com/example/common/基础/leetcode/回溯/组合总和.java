package com.example.common.基础.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum(new int[]{1,2}, 3);
        for (List<Integer> re : res) {
            System.out.printf("" + re);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(ans, temp, 0, 0, candidates, target);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> temp, int index, int sum, int[] candidates, int target) {
        if (sum >= target) {//这段代码的终止条件是 if (sum >= target)，一旦 sum 超过 target 就直接返回（剪枝），避免无效递归
            if (sum == target) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        //这里dfs index=i是为了可以重复元素 每一个元素重复的去计算 这样才符合最后要求
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(ans, temp, i, sum + candidates[i], candidates, target);//注意这里的index用的是i 没有往下走 sum 是 temp 元素和的 “镜像”—— 加元素时 sum 同步加，删元素时 sum 通过递归栈 “自动回退”，永远不会出现不一致。
            temp.remove(temp.size() - 1);
        }
    }

}