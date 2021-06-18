package com.example.common.基础.异步编程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDo {

    static  void aa() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = (Future<String>) executorService.submit(() -> {
            System.out.printf("这里是线程要执行的内容1111");
        });
        Future<String> future1 = (Future<String>) executorService.submit(() -> {
            System.out.printf("这里是线程要执行的内容22222");
        });
        Thread.sleep(10000);

        if (future.isDone()) {
            System.out.printf("执行完了");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        aa();
        System.out.printf("测试");
    }
}
