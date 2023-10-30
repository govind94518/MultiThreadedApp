package Exercise.EvenOddThread;

public class Main {
    public static int curr = 1;
    public static int limit = 20;
    public  static boolean even = true;
    public  static boolean odd = true;

    public static void main(String[] args) {
        Object lock= new Object();
        new Thread(new EvenThread(lock)).start();
        new Thread(new EvenThread(lock)).start();
        new Thread(new OddThread(lock)).start();
        new Thread(new OddThread(lock)).start();

    }
}
