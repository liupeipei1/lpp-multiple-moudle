package com.example.springbootproject.基础.锁;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        class My_thread01 extends Thread {

            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 10000; i++) {
                        count++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        class My_thread02 extends Thread {

            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 10000; i++) {
                        count++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
        My_thread01 t1 = new My_thread01();
        My_thread02 t2 = new My_thread02();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.printf("count is " + count);

    }
}