package com.lilb.laggard.practice;

public class DeadLock {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (resource1) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("...");
                }
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (resource2) {
                synchronized (resource1) {
                    System.out.println("...");
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
