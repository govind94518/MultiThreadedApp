package ProducerConsumerProblem;

public class Main {
    public  static  int producerCount = 10;

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue(50);

        for(int i=0;i<12;i++)
            new Thread(new Consumer(myQueue)).start();

        for (int i=0;i<10;i++)
            new Thread(new Producer(myQueue)).start();

//        Thread thread1 = new Thread(new Producer(myQueue));
//        Thread thread2 = new Thread(new Consumer(myQueue));
//        thread1.start();
//        thread2.start();
    }
}
