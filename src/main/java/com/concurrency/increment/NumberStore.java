package com.concurrency.increment;

public class NumberStore {
    private int x;  //shared variable across different threads
    // that is why race condition occur

    public NumberStore() {
        x = 0;
    }

    //    public  synchronized void  increment(){
//        x++;  //three  step process
//        //critical condition leads to race condition
//        //during 3 steps other thread we do not allow any thread to enter into critical condition
//    }
    public  void increment() {
        synchronized (this){
            x++;
        }
        //three  step process
        //critical condition leads to race condition
        //during 3 steps other thread we do not allow any thread to enter into critical condition
    }

    public int getX() {
        return x;
    }

}
