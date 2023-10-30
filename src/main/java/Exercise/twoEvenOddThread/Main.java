package Exercise.twoEvenOddThread;

public class Main {
    public static int curr = 1;
    public static int limit = 20;
    public  static boolean even = false;
    public  static boolean odd = false;

    public static void main(String[] args) {
        Object lock= new Object();
        new Thread(new EvenThread("even-1 ",lock)).start();
        new Thread(new EvenThread("even-2",lock)).start();
        new Thread(new OddThread("odd-1",lock)).start();
        new Thread(new OddThread("odd-2",lock)).start();

    }
}
