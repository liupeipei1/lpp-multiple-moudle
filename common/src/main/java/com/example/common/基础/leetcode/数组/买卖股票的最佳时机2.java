package com.example.common.基础.leetcode.数组;

import com.google.common.base.Enums;

/*
给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股股票。你也可以购买它，然后在 同一天 出售。
返回你能获得的 最大 利润 。
输入：prices = [7,1,5,3,6,4]
输出：7
解释：在第 2 天（股票价格 = 1）的时候买入，
在第 3 天（股票价格 = 5）的时候卖出,
这笔交易所能获得利润 = 5-1 = 4 。随后，
在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出,
这笔交易所能获得利润 = 6-3 = 3 。总利润为 4 + 3 = 7 。

 */
public class 买卖股票的最佳时机2 {
    public static void main(String[] args) {
        买卖股票的最佳时机2 solution = new 买卖股票的最佳时机2();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);
        System.out.println(result); // 输出: 7
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5})); // 输出: 4

    }

    //贪心算法 核心是抓住所有上涨的差价，用贪心算法就能高效解决
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
