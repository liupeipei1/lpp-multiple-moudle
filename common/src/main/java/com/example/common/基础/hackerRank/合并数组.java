package com.example.common.基础.hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 合并数组 {
    public static void main(String[] args) {
        List<List<Integer>> in= new ArrayList<>();
        List<Integer> sub1= new ArrayList<>();
        sub1.add(1);
        sub1.add(3);
        in.add(sub1);
        List<Integer> sub2= new ArrayList<>();
        sub2.add(2);
        sub2.add(6);
        in.add(sub2);
        List<Integer> sub3= new ArrayList<>();
        sub3.add(8);
        sub3.add(10);
        in.add(sub3);
        List<List<Integer>> rs=   mergeArray(in);
        System.out.printf("rs"+ rs.toString());

        List<List<Integer>> rs1=   mergeHighDefinitionIntervals(in);
        System.out.printf("rs"+ rs1.toString());
    }

    public static List<List<Integer>> mergeArray(List<List<Integer>> arr) {
        if (arr == null || arr.size() == 0) return arr;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Collections.sort(arr, (a, b) -> a.get(0) - b.get(0)); //排序 那么只要比较最左边的值就好了
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> current= arr.get(i);
            //判断当前值不存在第一个区间
            if (result.isEmpty() || current.get(0) > result.get(result.size() - 1).get(1)) { //第一个最左边的值 大于当前值最右边
                result.add(current);
            } else { //当存在交际
                int max = Math.max(current.get(1), result.get(result.size() - 1).get(1));
                result.get(result.size() - 1).set(1, max);
            }

        }
        return result;
    }

    public static List<List<Integer>> mergeHighDefinitionIntervals(List<List<Integer>> intervals) {
        // Write your code here
        if(intervals == null || intervals.size()==0 ){return intervals;}
        Collections.sort(intervals,(a,b)-> a.get(0)-b.get(0));

        List<List<Integer>> result =new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if(result.isEmpty() ||  intervals.get(i).get(0)> result.get(result.size()-1).get(1)) {
                result.add(intervals.get(i));
            }else{
                int maxLeft = Math.max( intervals.get(i).get(1), result.get(result.size()-1).get(1));
                result.get(result.size()-1).set(1, maxLeft);

            }

        }
        return result;

    }
}
