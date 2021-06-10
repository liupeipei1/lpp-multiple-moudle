package com.example.springbootproject.基础.single;

public class NOSynchronized implements Runnable {

    @Override
    public void run() {
        int a=1;
        NOSynchronized tt = new NOSynchronized();
        a++;

        System.out.println("BB"+a);

    }
}
