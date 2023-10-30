package Exercise.sortedseuence;

public class Worker implements Runnable {
    Object lock;
    int val;

    public Worker(int val, Object lock) {
        this.lock = lock;
        this.val = val;
    }

    public void run() {

        synchronized (lock) {
            while (val > SortedSequence.value) {
                try {
                    lock.wait();
                    //   System.out.println("thread needs to wait.................");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(SortedSequence.value);
            SortedSequence.value++;
            lock.notifyAll();
        }

    }

}
