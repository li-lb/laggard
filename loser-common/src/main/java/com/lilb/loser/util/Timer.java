package com.lilb.loser.util;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author 李琳碧
 */
public class Timer {

    public static void main(String[] args) {
        // 示例代码：
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" +
                        "线程名称: " + Thread.currentThread().getName());
            }
        };
        System.out.println("当前时间: " + new Date() + "n" +
                "线程名称: " + Thread.currentThread().getName());
        Timer timer = new Timer();
        long delay = 1000L;
        //timer.
        //timer.schedule(task, delay);

    }

}
