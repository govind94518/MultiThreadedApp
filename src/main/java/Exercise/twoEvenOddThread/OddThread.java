package Exercise.twoEvenOddThread;

public class OddThread implements Runnable {
    Object lock;
    String threadName;

    public OddThread(String threadName, Object lock) {
        this.threadName = threadName;
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
        while (Main.curr <= Main.limit) {
                while ((Main.curr % 2 == 0 || Main.odd) && Main.curr <= Main.limit) {
                    try {
                          System.out.println(threadName +"  currently sleep OddThread "+Main.curr);
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (Main.curr > Main.limit) {
                    lock.notifyAll();
                    break;
                }
                if (Main.curr % 2 != 0) {
                    System.out.println(threadName + " Thread ..." + Main.curr);
                    Main.odd = !Main.odd;
                    Main.curr++;
                    lock.notifyAll();
                }

            }
        }

    }
}
