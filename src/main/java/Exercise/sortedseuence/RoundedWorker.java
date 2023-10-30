package Exercise.sortedseuence;


public class RoundedWorker implements Runnable {

    Object lock;
    int threadAssignedValue;
    int round;

    public RoundedWorker(int threadAssignedValue, Object lock, int round) {
        this.lock = lock;
        this.threadAssignedValue = threadAssignedValue;
        this.round = round;
    }

    public void run() {

        while (round > 1) {

            synchronized (lock) {

                while (threadAssignedValue != SortedSequence.value) {
                        try {
                            lock.wait();
                            System.out.println("thread is waiting ..........."+threadAssignedValue);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                }
                System.out.println(SortedSequence.value);
                SortedSequence.value++;
                lock.notifyAll();

                if (SortedSequence.value > 10) {
                    SortedSequence.value = SortedSequence.value % 10;
                    round--;
                    lock.notifyAll();
                 //   System.out.println("next round started................");

                }
            }
        }

    }
//public void run() {
//
//
//    while (round > 0) {
//        synchronized (lock) {
//            while (threadAssignedValue != RoundedSortedSequence.value) {
//                try {
//                    lock.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//            System.out.println(RoundedSortedSequence.value);
//            RoundedSortedSequence.value++;
//
//            if (RoundedSortedSequence.value > 10) {
//                RoundedSortedSequence.value = 1;
//                round--;
//
//                if (RoundedSortedSequence.threadsFinished < RoundedSortedSequence.totalThreads - 1) {
//                    RoundedSortedSequence.threadsFinished++;
//                } else {
//                    RoundedSortedSequence.threadsFinished = 0;
//                    lock.notifyAll();
//                }
//            } else {
//                lock.notifyAll();
//            }
//        }
//    }
//}
}


