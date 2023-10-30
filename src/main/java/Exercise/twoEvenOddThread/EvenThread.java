package Exercise.twoEvenOddThread;


public class EvenThread implements Runnable {
    Object lock;//monitor
    String threadName;

    public EvenThread(String threadName, Object lock) {
        this.threadName = threadName;

        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
        while (Main.curr <= Main.limit) {
                while ((Main.curr % 2 != 0 || Main.even) && Main.curr <= Main.limit) {
                    try {
                            System.out.println(threadName +" currently sleep EvenThread "+Main.curr);
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (Main.curr > Main.limit) {
                    lock.notifyAll();
                    break;
                }
                if (Main.curr % 2 == 0) {
                    System.out.println(threadName + " Thread ..." + Main.curr);
                    Main.even = !Main.even;
                    Main.curr++;
                    lock.notifyAll();
                }

            }
        }

    }
}
