package com.example.common.基础.Thread;

import java.util.concurrent.TimeUnit;

public class TheadRun {
    public static void main(String[] args) {
        Thread aa = new Thread(() -> {//等价调用  public Thread(Runnable target) { 方法
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.printf("我正在进行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //第二种接口方式  lambda必须是接口才可以这样
        Runnable bb = () -> {
            int a = 1;
        };
        aa.run();
        System.out.printf("主线程退出");
    }

    Thread1 tt = () -> {
        System.out.printf("111111");
    };


}
