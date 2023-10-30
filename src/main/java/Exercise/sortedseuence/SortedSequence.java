package Exercise.sortedseuence;

public class SortedSequence {
    public static int value = 1;

    public static void main(String[] args) {
        Object lock = new Object();
        for (int i = 1; i <= 10; i++)
            new Thread(new Worker(i, lock )).start();

    }
}
