package Exercise.EvenOddThread;


public class EvenThread implements Runnable {
    Object lock;//monitor

    public EvenThread(Object lock) {
        this.lock = lock;
    }

    public void run() {
        while (Main.curr <= Main.limit) {
            synchronized (lock) {
                while (Main.curr % 2 != 0 && Main.curr <=Main.limit) {
                    try {
                     //   System.out.println("currently sleep EvenThread "+Main.curr);
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
                    System.out.println("Even Thread ..." + Main.curr);
                    Main.curr++;
                    lock.notifyAll();
                }

            }
        }

    }
}
