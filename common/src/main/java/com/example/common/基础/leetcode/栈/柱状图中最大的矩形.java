package com.example.common.基础.leetcode.栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class 柱状图中最大的矩形 {


    public static void main(String[] args) {
        System.out.printf("\t" + largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.printf("\t" + largestRectangleArea3(new int[]{2, 4}));
        System.out.printf("\t" + largestRectangleArea(new int[]{0, 9}));
        System.out.printf("\t" + largestRectangleArea(new int[]{2, 1, 2}));
        System.out.printf("\t" + largestRectangleArea2(new int[]{2, 1, 2}));

    }

    /*(超出时间限制)
     「快慢指针」解决柱状图最大矩形问题，核心思路是把快慢指针作为「暴力枚举所有区间」的实现方式，但要明确：快慢指针本质还是暴力解法（时间复杂度 O (n²)），
     仅适用于小规模数据，大数据量会超时，但可以帮你理解问题的基础逻辑
     一、快慢指针的核心思路
    快慢指针的本质是「枚举所有可能的矩形区间」：
    慢指针 left：作为矩形的左边界（遍历每一根柱子）；
    快指针 right：作为矩形的右边界（从 left 开始向右遍历）；
    对每个 [left, right] 区间，找到区间内的最小高度（矩形的高度由最矮的柱子决定）；
    计算面积 最小高度 × (right - left + 1)，更新最大面积。
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length;
        int maxArea = 0;

        for (int left = 0; left < len; left++) {
            int miniHeight = heights[left];
            for (int right = left; right < len; right++) {
                // 更新区间[left, right]的最小高度（矩形高度由最矮柱子决定）
                miniHeight = Math.min(miniHeight, heights[right]);
                // 计算当前区间的面积：最小高度 × 宽度（right - left + 1）
                int miniArea = miniHeight * (right - left + 1);
                // 更新最大面积
                maxArea = Math.max(maxArea, miniArea);
            }
        }
        return maxArea;
    }

    /*单调栈
   「柱状图最大矩形」的核心是找每个柱子的左右第一个更矮柱子，单调栈是最优解法（时间复杂度 O (n)）；
   单调递增栈的作用：维护递增的柱子索引，遇到更矮的柱子时，批量计算栈内更高柱子的面积；
   虚拟右边界（i=len，高度 0）：确保遍历结束后，栈内剩余的柱子都能被处理（因为 0 比所有高度都小）。
   对每一根柱子 i，找到它「左边第一个比它矮的柱子索引 left」和「右边第一个比它矮的柱子索引 right」，
   则以 heights[i] 为高度的矩形宽度是 right - left - 1，面积是 heights[i] × (right - left - 1)。
   【2,1,2】
   第一次 i=0 存栈2
   第二次  i=1 1<2 然后  计算栈顶的面积 2*1=2 然后存 index=1
   第三次  i=2 存 index=2
   第四次  i=3 当前height是0 小于栈顶 stack[1,2]
          出栈顶2 宽度=3-1-1  右边界-左边界-1  这里相对于2而言说的左边界右边界 area= 2*1=2
          出栈顶1 宽度=3  area=3

    */
    public static int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length;
        // 单调递增栈：存储柱子索引，保证索引对应的高度递增
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i <= len; i++) {
            // 当前高度（i=len时，高度为0，用于处理栈内剩余元素）
            int currHeight = i == len ? 0 : heights[i];
            // 当前高度 < 栈顶高度 → 计算栈顶柱子的面积  (当前元素小于栈顶 这样就保证了栈里面的元素是一直递增的，因为这里有出栈，所以保证了递增性)
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {//找到小于栈顶的 所有柱状
                int topIndex = stack.pop();// 弹出栈顶（当前要计算的柱子索引）
                int height = heights[topIndex];// 矩形高度
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // 计算宽度：栈空则宽度为i，否则为i - 新栈顶 - 1
                ans = Math.max(ans, height * width);
            }
            //保证这里是递增的趋势
            stack.push(i);
        }
        return ans;
    }

    //数组的方式
    public static int largestRectangleArea3(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int len = heights.length;
        int[] stack = new int[len + 1]; //存储的是数组的下标
        int top = 0;
        int ans = 0;
        for (int i = 0; i <= len; i++) {
            int current = (i < len ? heights[i] : -1); //超过len则是特殊处理 因为需要覆盖所有的柱状图
            while (top > 0 && current < heights[stack[top]]) {//类似单调栈
                int topIndex = stack[top];
                top--;
                int height = heights[topIndex];//栈顶高度
                int width = top == 0 ? i : i - stack[top] - 1;//栈顶的= 右边界(i)-左边界(栈顶) -1
                ans = Math.max(ans, height * width);
            }
            top++;//意味着数组第index=0是没有记录下标
            stack[top] = i;
        }
        return ans;
    }
}
