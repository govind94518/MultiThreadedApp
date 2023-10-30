package com.concurrency.compact;

public class Number {
    int x;

    public Number() {
        x = 0;
    }

    public synchronized int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public void getAndIncrement() {
        synchronized (this) {
            int oldVal = getX();
            try {
                Thread.sleep(200);
            } catch (InterruptedException exp) {
                throw new RuntimeException(exp);
            }
            setX(oldVal + 1);
        }
    }
}
