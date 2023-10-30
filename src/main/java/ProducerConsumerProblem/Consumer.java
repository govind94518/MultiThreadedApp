package ProducerConsumerProblem;

public class Consumer implements Runnable {
    MyQueue queue;

    public Consumer(MyQueue  queue) {
        this.queue = queue;
    }

    public void run() {
              while (true){
                  synchronized (queue){
                        while(queue.isEmpty() && Main.producerCount>0) {
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if(Main.producerCount==0){
                            queue.notifyAll();
                            break;
                        }
                        int x = queue.pop();
                        System.out.println("Consumer consumed "+x);
                        queue.notifyAll();

                        if(x==-1) {
                            Main.producerCount--;
                            break;
                        }
            }
        }
    }
}
