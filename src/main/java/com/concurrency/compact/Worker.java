package com.concurrency.compact;

public class Worker implements Runnable {
    Number number;

    public Worker(Number number) {
        this.number = number;
    }

    public void run() {
        number.getAndIncrement();
    }
}