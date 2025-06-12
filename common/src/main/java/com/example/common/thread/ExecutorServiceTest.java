package com.example.common.thread;

import java.util.Random;

/*
刘佩佩
2023/11/29
*/
public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            setEmail();
        }
    }

    public static boolean setEmail() throws InterruptedException {
        Thread.sleep(1000);
        Random random=new Random();
       return random.nextBoolean();
    }
}
