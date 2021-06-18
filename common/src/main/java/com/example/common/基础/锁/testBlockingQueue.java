package com.example.common.基础.锁;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class testBlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        arrayBlockingQueue.add("1");
        //arrayBlockingQueue.offer("222");
        arrayBlockingQueue.offer("333", 1000,TimeUnit.MILLISECONDS);

        Iterator in = arrayBlockingQueue.iterator();

        while (in.hasNext()) {
            System.out.printf("AA" + in.next());
        }


    }
}
