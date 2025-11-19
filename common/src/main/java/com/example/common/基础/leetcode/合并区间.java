package com.example.common.基础.leetcode;

import java.util.Arrays;

/*
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class 合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals1 = {{4, 7}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {5, 6}};
        int[][] merged = merge(intervals); // 调用合并区间的方法
        int[][] merged1 = merge1(intervals); // 调用合并区间的方法

        for (int[] interval : merged) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        for (int[] interval : merged1) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }

    /*
    这是典型的「排序 + 贪心」解法：先按区间左端点排序，然后线性扫描并贪心合并重叠区间。
    时间复杂度 O(n log n)（排序），空间复杂度 O(n)（结果数组，亦可用原地或栈优化）
     1. 排序：首先根据每个区间的起始位置对所有区间进行排序。
        2. 合并：然后遍历排序后的区间列表，比较当前区间的起始位置和上一个合并区间的结束位置。如果当前区间的起始位置小于等于上一个合并区间的结束位置，
        说明两个区间有重叠，可以将它们合并为一个新的区间，更新结束位置为两个区间结束位置的最大值。如果没有重叠，则将当前区间添加到结果列表中。
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        //1. 排序  升序的方式进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int idx = 0;
        int[][] merged = new int[intervals.length][2];
        // 初始化第一个区间到结果数组
        merged[0][0] = intervals[0][0];
        merged[0][1] = intervals[0][1];
        if (intervals.length == 1) {
            return intervals;
        }
        //2.根据每一个子区间判断是否存在这个范围
        for (int i = 1; i < intervals.length; i++) {
            //判断当前区间是否在已经确定的范围内
            if (intervals[i][0] > merged[idx][1]) { //当前区间的左边界大于已经确定的右边界 说明不在这个范围内
                idx++;
                merged[idx][0] = intervals[i][0];
                merged[idx][1] = intervals[i][1];
            } else {
                //重叠，更新右边界为最大值
                merged[idx][1] = Math.max(merged[idx][1], intervals[i][1]);
            }
        }
        //保留有效部分（索引从0到idx）
        merged = Arrays.copyOf(merged, idx + 1); //这里是因为 idx 是从0开始的 所以要加1
        return merged;
    }

    /*
    别人的解法  思路和上面的一样  只是写法不一样
    这是典型的「排序 + 贪心」解法。先对区间按左端点排序，然后线性扫描：若当前区间与结果列表最后一个区间不重叠则追加，否则合并并更新右端点为最大值。
    时间复杂度 O(n log n)，空间复杂度 O(n)。
     */
    public static int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        java.util.List<int[]> res = new java.util.ArrayList<>();
        for (int[] cur : intervals) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < cur[0]) {//右边的数据不在范围内 不重叠
                res.add(new int[]{cur[0], cur[1]});
            } else { //重叠  合并区间 这里只要考虑右边的大小就好 因为前面已经将数组进行排序了 所以左边一定是小于等于的
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], cur[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
