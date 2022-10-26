package com.example.common.基础.多线程;

public class MuRunnable implements Runnable {
    private int a = 5;


    @Override
    public void run() {
        //System.out.printf("当前线程"+a);
        System.out.println(Thread.currentThread().getName() + " is running...");

    }


}
