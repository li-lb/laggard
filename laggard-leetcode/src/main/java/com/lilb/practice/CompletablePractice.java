package com.lilb.practice;

import java.util.concurrent.CompletableFuture;

public class CompletablePractice {

    /*public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("第一个");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "1";
        });
        completableFuture.whenCompleteAsync((s, e) -> {

            try {
                System.out.println("completableFuture" + Thread.currentThread());
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(s);
            System.out.println(e.getMessage());
        });
        System.out.println("main");
        Thread.sleep(2000);
    }*/

    public static void main(String[] args) {

        CompletableFuture stringCompletableFuture = new CompletableFuture<>();

        stringCompletableFuture.whenCompleteAsync((e, a) -> {
            System.out.println("Complete " + e);

            try {
                Thread.sleep(100);

            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        });


    }


}
