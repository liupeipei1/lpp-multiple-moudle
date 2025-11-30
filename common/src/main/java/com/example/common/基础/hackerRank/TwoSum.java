package com.example.common.基础.hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
  If a solution exists,
  return two distinct indices i, j such that 0 <= i < j < n and taskDurations[i] + taskDurations[j] = slotLength
Given an array of positive integers and a target integer, return the indices of two elements that sum to the target or [-1, -1] if no such pair exists.
 */
public class TwoSum {
    public static void main(String[] args) {

    }

    public static List<Integer> findTaskPairForSlot(List<Integer> taskDurations, int slotLength) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < taskDurations.size(); i++) {
            int target = slotLength - taskDurations.get(i);
            if (map.containsKey(target)) {
                result.add(i);
                result.add(map.get(target));
            }
            map.put(taskDurations.get(i), i);
        }
        if (result.isEmpty()) {
            result.add(-1);
            result.add(-1);
        }
        return result;
    }
}
