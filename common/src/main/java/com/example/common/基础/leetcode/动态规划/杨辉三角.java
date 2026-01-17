package com.example.common.基础.leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

/*
 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。
杨辉三角示例：
输入：numRows = 5
输出：[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
解释：
第 1 行：        [1]
第 2 行：       [1,1]
第 3 行：      [1,2,1]
第 4 行：     [1,3,3,1]
第 5 行：    [1,4,6,4,1]
特点：最边边的都是1，中间的数是上面两个数相加。
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        System.out.printf("\n" + generate(5));//[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        System.out.printf("\n" + generate2(5));//[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    }


    //注意这里的add list 如果是指定下标一定是已经add过的 否则会报错
    //暴力破解方法
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(); //set list size
            //设置第一行 和第二行都为0
            if (i < 2) {
                for (int j = 0; j <= i; j++) {
                    list.add(1);
                }
                result.add(list);
                continue;
            }
            list.add(1); //当前列第一行值
            //处理中间的值
            List<Integer> preList = result.get(i - 1); //获取上一行的数据
            for (int j = 1; j < preList.size(); j++) { //当前行计算值
                int value = preList.get(j) + preList.get(j - 1);
                list.add(j, value);
            }
            list.add(1);//当前列最后一行值
            result.add(list);
        }
        return result;
    }

    //动态规划
    /*
     杨辉三角具有以下性质：
    每行数字左右对称，由 1 开始逐渐变大再变小，并最终回到 1。
        第 n 行（从 0 开始编号）的数字有 n+1 项，前 n 行共有 n(n+1)/2个数。
    第 n 行的第 m 个数（从 0 开始编号）可表示为可以被表示为组合数 C(n,m)，记作 C
     )，即为从 n 个不同元素中取 m 个元素的组合数。我们可以用公式来表示它：C
    每个数字等于上一行的左右两个数字之和，可用此性质写出整个杨辉三角。即第 n 行的第 i 个数等于第 n−1 行的第 i−1 个数和第 i 个数之和。这也是组合数的性质之一，即 C
      的展开式（二项式展开）中的各项系数依次对应杨辉三角的第 n 行中的每一项。
         */
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(); //set list size
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) { //第一个和最后一个都是1
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

}
