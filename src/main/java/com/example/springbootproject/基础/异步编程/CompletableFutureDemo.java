package com.example.springbootproject.基础.异步编程;

import java.util.concurrent.CompletableFuture;


public class CompletableFutureDemo {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(CompletableFutureDemo::getPrice).thenAccept(result ->{
            System.out.printf("价格是"+getPrice());
        });
    }

    static  Double getPrice(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("11111");

        return  Math.random()*20;
    }
}
