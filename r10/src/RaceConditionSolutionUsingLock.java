
class Counter1 {
    private int count = 0;
    private final Object lock = new Object(); // Create a lock object

    // Method to increment the counter
    public void increment() {
//        count++;  // This operation is not atomic
        synchronized (lock) { // Synchronize on the lock object
            count++;  // Critical section/region
        }
    }

    public int getCount() {
        return count;
    }
}

class CounterThread1 extends Thread {
    private Counter1 counter;

    // Constructor to set the shared Counter instance
    public CounterThread1(Counter1 counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();  // Increment the shared counter
        }
    }
}

public class RaceConditionSolutionUsingLock {
    public static void main(String[] args) {
        Counter1 counter = new Counter1();

        // n threads
        int n = 1000;
        CounterThread1[] threadList = new CounterThread1[n];
        for (int i = 0; i < threadList.length; i++) {
            threadList[i] = new CounterThread1(counter);
            threadList[i].start();
        }

        // Wait for both threads to finish
        for (CounterThread1 counterThread : threadList) {
            try {
                counterThread.join();
            } catch (InterruptedException e) {
                System.out.println("Threads interrupted.");
            }
        }

        // Print the final count
        System.out.println("Final count is: " + counter.getCount());
    }
}

