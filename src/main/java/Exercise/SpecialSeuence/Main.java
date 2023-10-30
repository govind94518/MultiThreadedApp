package Exercise.SpecialSeuence;


public class Main {
    public static int n = 10;
    public static int count = 0;
    public static int zerosCount = 1;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread odd= new Thread(new Odd(lock));
        Thread even= new Thread(new Even(lock));
        Thread zero = new Thread(new Zero(lock));
        odd.start();
        even.start();
        zero.start();
    }
}
