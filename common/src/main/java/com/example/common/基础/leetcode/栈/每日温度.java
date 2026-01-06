package com.example.common.基础.leetcode.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，
 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
是离当前温度下一个高于当前温度的天数是
 */
public class 每日温度 {
    public static void main(String[] args) {
        // int[] rs = dailyTemperatures1(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        int[] rs = dailyTemperatures1(new int[]{75, 71, 69, 72});

        for (int i = 0; i < rs.length; i++) {
            System.out.printf("\n" + rs[i]);
        }

    }


    //超出时间限制了
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 0; //默认值是0
            for (int j = i + 1; j < n; j++) {
                if (temperatures[i] < temperatures[j]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    /*
      栈的方式
      需先明确单调栈的「单调递减」特性 栈中存储的是「未找到更高温度的索引」，且这些索引对应的温度是从栈底到栈顶递减的。
     */
    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];// 初始值默认0，无需额外赋值
        Deque<Integer> stack = new ArrayDeque<>();// 存储未找到更高温度的索引
        for (int i = 0; i < n; i++) {
            //关键：弹出所有「栈顶索引的温度 < 当前温度」的元素当前温度 > 栈顶索引的温度 → 栈顶索引找到了更高温度，计算天数差
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {//用 while 是为了一次性处理栈中所有「温度低于当前值」的索引
                int prevIdx = stack.pop(); // 弹出已找到结果的索引
                ans[prevIdx] = i - prevIdx; // 核心：计算天数差
            }
            // 压入当前索引，保证栈内剩余元素仍单调递减
            stack.push(i);
        }
        return ans;
    }

}
