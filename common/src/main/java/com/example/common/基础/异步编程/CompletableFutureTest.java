package com.example.common.基础.异步编程;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<CompletableFuture<Boolean>> completableFutures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            completableFutures.add(CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.printf(" for "+Thread.currentThread()+"\n");
                    return sendEMail();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }
        doOthers();
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        for (CompletableFuture<Boolean> completableFuture : completableFutures) {// using main thread,当加入现成后，这里就是主线程了
            System.out.printf(" email status:" + completableFuture.get()+"\n"+Thread.currentThread());
        }

    }


    public  static  boolean sendEMail() throws InterruptedException {
        Thread.sleep(10000);
        Random random = new Random();
        return random.nextBoolean();
    }

    public static void doOthers() {
        System.out.printf(" do others ");
    }
}
