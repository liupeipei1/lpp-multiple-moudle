package com.example.common.基础.hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 找到缺失的最小正整数 {
    public static void main(String[] args) {
        List<Integer> orderNumbers = new ArrayList<>();
        orderNumbers.add(-1);
        orderNumbers.add(0);
        orderNumbers.add(1);
        orderNumbers.add(3);
        orderNumbers.add(4);
        System.out.printf("result:" + findSmallestMissingPositive(orderNumbers));

    }

    public static int findSmallestMissingPositive(List<Integer> orderNumbers) {
        // Write your code here
        Collections.sort(orderNumbers);
        int mini = 1;
        for (Integer orderNumber : orderNumbers) {
            if (orderNumber <= 0 || orderNumber < mini) {
                continue;
            }

            if (mini == orderNumber) {
                mini++;
            } else if (orderNumber > mini) {
                return mini;
            }
        }
        return mini;
    }
}
