package com.example.common.基础.leetcode.堆;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
输入：nums = [1,1,1,2,2,3], k = 2
输出：[1,2]
 */
public class 前k个高频元素 {

    public static void main(String[] args) {
        //int[] r = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        // int[] r = topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2);
       // int[] r = topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        int[] r = topKFrequent2(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);

        for (int i = 0; i < r.length; i++) {
            System.out.printf("\t" + r[i]);
        }
    }

    //map + 小堆顶
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //原代码：(a, b) -> b.getValue() - a.getValue() → 大顶堆 (a, b) -> a.getValue() - b.getValue() → 小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue)); //定义排序规则 这里存储的是map但是却是用 value进行升序排序
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        map.forEach((s, integer) -> {
            if (pq.size() < k) {
                pq.add(Map.entry(s, integer));
            } else {
                if (integer > pq.peek().getValue()) {
                    pq.poll();
                    pq.add(Map.entry(s, integer));
                }
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }


    //map +小堆顶
    public static int[] topKFrequent2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0 || k > nums.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();//统计频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //小堆顶
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );  //这里堆里面存储的是 map的key 但是 用的是map里面的value进行升序排序 更方便

        map.forEach((s, integer) -> {
            if (pq.size() == k) {
                if (integer > map.get(pq.peek())) { //当前元素出现的次数大于堆顶的次数 需要将堆顶的数据remove
                    pq.poll();
                    pq.add(s); //添加新的元素
                }
            } else {
                pq.offer(s);
            }
        });
        int[] r = new int[k];
        int index = 0;
        for (Integer i : pq) {
            r[index++] = i;
        }
        return r;
    }
}
