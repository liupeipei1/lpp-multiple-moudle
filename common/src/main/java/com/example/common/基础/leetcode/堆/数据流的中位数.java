package com.example.common.基础.leetcode.堆;

/*
 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
例如 arr = [2,3,4] 的中位数是 3 。
例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
实现 MedianFinder 类:
MedianFinder() 初始化 MedianFinder 对象。
void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 */
public class 数据流的中位数 {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(12);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(10);
        System.out.printf("\t" + mf.findMedian());


        mf.addNum(13);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(11);
        System.out.printf("\t" + mf.findMedian());


        mf.addNum(5);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(15);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(1);
        System.out.printf("\t" + mf.findMedian());


        mf.addNum(11);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(6);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(17);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(14);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(8);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(17);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(6);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(4);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(16);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(8);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(10);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(2);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(12);
        System.out.printf("\t" + mf.findMedian());

        mf.addNum(0);
        System.out.printf("\t" + mf.findMedian());
    }
}
