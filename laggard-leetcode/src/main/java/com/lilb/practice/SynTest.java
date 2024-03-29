package com.lilb.practice;

public class SynTest implements Runnable {
    public static void main(String[] args) {
        new Thread(new SynTest()).start();
        new Thread(new SynTest()).start();//两句话几乎是同时输出的
    }

    @Override
    public synchronized void run() {
        System.out.println("run执行了");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
