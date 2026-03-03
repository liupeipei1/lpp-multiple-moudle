package com.example.common.基础.leetcode.数组;

/*
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。


 */
public class 买卖股票最佳时机 {

    public static void main(String[] args) {
        买卖股票最佳时机 solution = new 买卖股票最佳时机();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);
        System.out.println(result); // 输出: 5
    }


    /*
     这里不用担心价格为负数的情况 因为题目中已经说明了价格是非负数的 只需要在遍历数组的过程中记录当前的最低价格和最大利润即可
     也不用担心价格为0的情况 因为题目中已经说明了价格是非负数的 只需要在遍历数组的过程中记录当前的最低价格和最大利润即可
     具体来说，我们可以初始化一个变量 minPrice 来记录当前的最低价格，初始值为 Integer.MAX_VALUE。然后我们遍历数组中的每个价格 price：
     1. 更新最大利润：我们计算当前价格 price 与 minPrice 之间的利润，即 price - minPrice，并将其与当前的最大利润 maxProfit 进行比较，更新 maxProfit 的值。
     2. 更新最低价格：我们将 minPrice 更新为当前价格 price 与 minPrice 之间的较小值，以确保 minPrice 始终保持为当前遍历过的最低价格。
     最后，maxProfit 就是我们能够获得的最大利润。如果 maxProfit 的值为负数，说明没有任何利润可言，我们可以返回 0。
     这种方法的时间复杂度为 O(n)，因为我们只需要遍历一次数组，空间复杂度为 O(1)，因为我们只使用了常数级别的额外空间来存储 minPrice 和 maxProfit 变量。
       下面是使用上述方法实现的代码示例：
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }

    //超出时间限制
    @Deprecated
    public int maxProfit_(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
