package com.example.common.基础.leetcode.贪心算法;

import java.util.ArrayDeque;
import java.util.Deque;

/*
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.printf("\n" + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.printf("\n" + maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.printf("\n" + maxProfit2(new int[]{7, 8, 5, 3, 6, 4}));


    }

    //超出时间限制了
    @Deprecated
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int pre = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (pre > prices[j]) {
                } else {
                    max = Math.max(prices[j] - pre, max);
                }
            }
        }
        return max;
    }

    //可以使用
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0;
        int mini[] = new int[2];//记录最小的数和index
        mini[0] = prices[0];
        mini[1] = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < mini[0]) { //找到最小的数
                mini[0] = prices[i];
                mini[1] = i;
            }
            if (i > mini[1]) {
                max = Math.max(max, prices[i] - mini[0]);
            }
        }
        return max;
    }

    //可以使用 最简单的方式  可以理解成 找到price[i]前面最小的数  和与当前price[i] 差距最大的值
    //所以不存在 最小值在后面 低卖 高买的可能性
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPre = Integer.MAX_VALUE;
        int maxPre = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPre = Math.min(minPre, prices[i]);
            maxPre = Math.max(maxPre, prices[i] - minPre);
        }
        return maxPre;
    }

}
