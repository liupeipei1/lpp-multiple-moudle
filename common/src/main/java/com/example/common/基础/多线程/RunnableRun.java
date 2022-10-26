package com.example.common.基础.多线程;

public class RunnableRun {
    public static void main(String[] args) {

        Thread aa = new Thread(new MuRunnable());

        aa.start();
    }
}
