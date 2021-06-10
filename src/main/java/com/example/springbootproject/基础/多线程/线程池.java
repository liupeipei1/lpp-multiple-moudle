package com.example.springbootproject.基础.多线程;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class 线程池 {

    public  static void main(String[] args) {
       // ExecutorService executorService = Executors.newSingleThreadExecutor();//默认一个
      //  ExecutorService executorService = Executors.newFixedThreadPool(2);  //要制定线程数
       // ExecutorService executorService = Executors.newCachedThreadPool();//CachedThreadPool 没有核心线程，非核心线程数无上限，也就是全部使用外包，但是每个外包空闲的时间只有 60 秒，超过后就会被回收
       ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);


        MuRunnable myRunnable = new MuRunnable();
        for (int i = 0; i < 10; i++) {
            executorService.execute(myRunnable);
        }

        System.out.println("线程任务开始执行");
        executorService.shutdown();
    }

}
