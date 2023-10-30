package ProducerConsumerProblem;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    int front;
    int rear;
    List<Integer> list;
    int capacity;

    public MyQueue(int capacity) {
        this.list = new ArrayList<Integer>();
        front = -1;
        rear = 0;
        this.capacity = capacity;
    }
      public boolean isFull() {
       if((front-rear+1)==capacity){
           System.out.println("Message Queue  is Full ");
           return true;
       }
          return false;
    }

    public boolean isEmpty() {
        if( rear > front){
            System.out.println("Message Queue  is Empty ");
            return true;
        }
        return false;
    }

    public void push(int x) {
        if(isFull())
            throw new RuntimeException("Message Queue  Overflow .............");
           list.add(x);
           front++;
    }

    public Integer pop() {
        if(isEmpty())
            throw new RuntimeException("Message Queue Underflow .............");
        return list.get(rear++);

    }




}
