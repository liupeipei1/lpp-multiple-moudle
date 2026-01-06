package com.example.common.基础.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class 子集 {
    public static void main(String[] args) {
        List<List<Integer>> rs = subsets(new int[]{1, 2, 3});
        for (List<Integer> r : rs) {
            // System.out.println(r);
        }

        List<List<Integer>> rs1 = subsets1(new int[]{1, 2});
        for (List<Integer> r : rs1) {
            System.out.println(r);
        }
    }

    /*
     迭代实现子集枚举   当数组size=3  那么存在2的3次方8个排列组合  非常聪明的做法
     当位数存在1说明对应的位置的数字存在
     例如，n=3 ，a={5,2,9}
        000	{}	0  所有位为空 说明是空集合
        001	{9}	1    第0位是1 子集只能是
        010	{2}	2
        011	{2,9}	3
        100	{5}	4
        101	{5,9}	5
        110	{5,2}	6
        111	{5,2,9}	7
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        // 遍历所有mask（0 ~ 2^n -1）
        for (int mask = 0; mask < (1 << n); mask++) { //将所有存在的二进制的可能性便利出来了
            List<Integer> subset = new ArrayList<>();
            // 检查每一位i是否为1
            for (int i = 0; i < n; i++) { //第二个循环负责 “把抽象的二进制状态（mask）翻译成具体的子集列表”。
                // 1 << i 把十进制的 i 转换成 “只有第 i 位为 1 的二进制标记数” 所以这里当n=3 只有三种 001  010 100 对应的就是三个数分别出现一次 当最外层的循环中和最里面的二进制与存在1 就说明是子集
                if ((mask & (1 << i)) != 0) { // 第i位为1 → 加入子集   i=0=十进制1-> 001 i=1=十进制2->010 i=2->十进制4-> 100
                    subset.add(nums[i]);
                }
            }
            res.add(subset);
        }
        return res;
    }


    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    //solution2 递归法实现子集
    public static List<List<Integer>> subsets1(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    /*
     数组只有 1 个元素，对应 1 个岔路口，一步一步看代码做了什么：
    初始调用 dfs(0, [1])（站在岔路口 0，元素 1）；
    先选元素 1：t=[1]，递归调用 dfs(1, [1])；
    此时 index=1 等于数组长度 1（走到尽头），把 [1] 存入结果；
    返回到选元素 1 的代码后面；
    反悔：t.remove(0) → t=[]（把 1 拿出来）；
    不选元素 1：递归调用 dfs(1, [1])；
    走到尽头，把 [] 存入结果；
    最终结果：[[1], []]（刚好是 [1] 的所有子集）。
     */
    public static void dfs(int index, int[] nums) {
        if (index == nums.length) {
            // 1. 走到路的尽头（所有元素都做过决策），把手里的元素存起来
            ans.add(new ArrayList<>(t));
            return;
        }
        // 2. 选当前元素：把元素放进手里，往前走一个岔路口
        t.add(nums[index]);
        dfs(index + 1, nums);
        // 3. 反悔不选：把刚放的元素拿出来，再往前走一个岔路口（走另一条路）
        t.remove(t.size() - 1);
        dfs(index + 1, nums);

    }

}
