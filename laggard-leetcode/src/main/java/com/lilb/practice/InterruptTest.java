package com.lilb.practice;

public class InterruptTest implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptTest());
        thread.start();
        Thread.sleep(100);//保证执行先于中断
        thread.interrupt();//程序在此处结束
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {//若为while(true)则interrupt不会中断程序
            System.out.println("123");
        }
    }
}
