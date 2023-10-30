package Exercise.FizzBuzz;

public class Main {

    public  static final int n = 15;
    public  static  int  i = 1;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread fizz= new Thread(new Fizz(lock));
        Thread Buzz= new Thread(new Buzz(lock));
        Thread FizzBuzz = new Thread(new FizzBuzz(lock));
        Thread plain = new Thread(new Plain(lock));
        fizz.start();
        Buzz.start();
        FizzBuzz.start();
        plain.start();
    }
}
