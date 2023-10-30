package Exercise.EvenOddThread;

public class OddThread implements Runnable {
    Object lock;

    public OddThread(Object lock) {
        this.lock = lock;
    }

    public void run() {
        while (Main.curr <= Main.limit) {
            synchronized (lock) {
                while (Main.curr % 2 == 0  && Main.curr <=Main.limit) {
                    try {
                       // System.out.println("currently sleep OddThread "+Main.curr);
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
                    System.out.println("Odd Thread ..." + Main.curr);
                    Main.curr++;
                    lock.notifyAll();
                }

            }
        }

    }
}
