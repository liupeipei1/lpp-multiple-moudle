package com.example.common.基础.hackerRank;

import java.util.List;

public class 得到超过平均数的个数 {


    /*
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
     */

    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        // Write your code here
        Double average = (double) responseTimes.get(0);// 得到第一个元素
        int count = 0;//计数
        Double sum = average;
        for (int i = 1; i < responseTimes.size(); i++) {
            if (i == 1 && responseTimes.get(i) > average) {
                count++;
            }
            sum += responseTimes.get(i);
            average = (double) sum / (i + 1);
            if (i > 1 && responseTimes.get(i) > average) {//当前的数大于平均数那么久需要计数
                count++;
            }
        }
        return count;
    }
}
