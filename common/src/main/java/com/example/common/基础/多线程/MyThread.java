package com.example.common.基础.多线程;

public class MyThread extends Thread {
    private volatile int count = 5;//

    @Override
    public void run() {
        count--;
        System.out.println(this.currentThread().getName() + " count:" + count);
    }

    /* public static void main(String[] args) {
         MyThread my = new MyThread();
         Thread thread1 = new Thread(my, "thread1");
         Thread thread2 = new Thread(my, "thread2");
         Thread thread3 = new Thread(my, "thread3");
         Thread thread4 = new Thread(my, "thread4");
         Thread thread5 = new Thread(my, "thread5");

         thread1.start();
         thread2.start();
         thread3.start();
         thread4.start();
         thread5.start();

     }*/

    //输出结果就会出现重复的数字  线程不安全
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(thread1, "thread" + i);
            t.start();
        }
    }
}
