package com.example.common.基础.异步编程;

import java.util.concurrent.CompletableFuture;


public class CompletableFutureDemo {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(CompletableFutureDemo::getPrice).thenAccept(result -> { //异步有返回值的异步
            System.out.printf("价格是" + getPrice());
        });
    }

    static Double getPrice() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("11111");

        return Math.random() * 20;
    }
}
