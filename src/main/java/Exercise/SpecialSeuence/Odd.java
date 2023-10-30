package Exercise.SpecialSeuence;


public class Odd implements Runnable {
    Object lock;

    public Odd(Object lock) {
        this.lock = lock;
    }


    public void run() {

        while (Main.zerosCount<=Main.n) {

            synchronized (lock) {
                while ( Main.zerosCount <= Main.n &&  ! (Main.count % 2 != 0 &&  Main.count >0)) {
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


                System.out.println(Main.count+ " Odd ");
                Main.count=0;
                Main.zerosCount++;
                lock.notifyAll();

            }
        }


    }
}