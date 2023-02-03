package com.lilb.loser.practice;

public class UnsafeThread {
    private static int num;

    public static void inCreate() {
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        //创建10000个线程，执行对num的加1操作
        for (int i = 0; i < 10000; i++) {
            new Thread(UnsafeThread::inCreate).start();
        }
        Thread.sleep(1000);//保证线程执行完毕
        System.out.println(num);//结果可能不为10000
    }
}
