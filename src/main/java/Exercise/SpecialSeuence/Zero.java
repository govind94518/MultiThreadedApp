package Exercise.SpecialSeuence;

public class Zero implements Runnable{
    Object lock;

    public Zero(Object lock) {
        this.lock = lock;
    }

    public void run() {

        while (Main.zerosCount<Main.n) {

            synchronized (lock) {

                while( Main.count != 0  ) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if ( Main.zerosCount>Main.n) {
                    System.out.println(Main.zerosCount + " terminating................Zero");
                    lock.notifyAll();
                    break;
                }

                System.out.println( 0 + "  zero");
                Main.count = Main.zerosCount;
                lock.notifyAll();



            }
        }

    }
}
