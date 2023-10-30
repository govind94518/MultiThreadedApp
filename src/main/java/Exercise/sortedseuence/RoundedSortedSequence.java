package Exercise.sortedseuence;

public class RoundedSortedSequence {

    public static int value = 1;
    public static int round = 2;
    public  static int totalThreads = 10;
    public  static int threadsFinished = 0;

    public static void main(String[] args) {
        Object lock = new Object();
        for (int i = 1; i <= 10; i++)
            new Thread(new RoundedWorker (i, lock, round)).start();

    }
}
