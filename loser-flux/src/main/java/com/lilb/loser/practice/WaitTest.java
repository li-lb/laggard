package com.lilb.loser.practice;

public class WaitTest implements Runnable {
    private static final Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始，线程准备挂起");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程恢复运行，结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new WaitTest());
        waitThread.start();
        Thread.sleep(100);//保证线程挂起发生于唤醒前
        synchronized (lock) {//挂起和唤醒需要持有相同的锁
            System.out.println("准备唤醒挂起线程");
            lock.notify();
        }
    }
}

