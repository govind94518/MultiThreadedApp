package Exercise.FizzBuzz;

//divided By 3 but not by 5
public class Fizz implements Runnable {
    Object lock;

    public Fizz(Object lock) {
        this.lock = lock;
    }


    public void run() {

        while (Main.i <= Main.n) {

            synchronized (lock) {
                while (Main.i <= Main.n && !(Main.i % 3 == 0 && Main.n % 5 != 0)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if (Main.i > Main.n) {
                    lock.notifyAll();
                    break;
                }
                System.out.println(Main.i + " Fizz");
                Main.i++;
                lock.notifyAll();
            }

        }

    }
}
