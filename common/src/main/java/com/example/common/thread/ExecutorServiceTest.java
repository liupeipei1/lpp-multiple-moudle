package com.example.common.thread;

import java.util.Random;

/*
刘佩佩
2023/11/29
*/
public class ExecutorServiceTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            setEmail();
        }
    }

    public boolean setEmail() {
        Thread.sleep(1000);
        Random random=new Random();
       return random.nextBoolean();
    }
}
