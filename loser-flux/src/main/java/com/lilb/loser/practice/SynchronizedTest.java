package com.lilb.loser.practice;

public class SynchronizedTest {

    public static void main(String[] args) {
        Thread why = new Thread(new TicketConsumer(10), "why");
        Thread mx = new Thread(new TicketConsumer(10), "mx");
        why.start();
        mx.start();
    }
}