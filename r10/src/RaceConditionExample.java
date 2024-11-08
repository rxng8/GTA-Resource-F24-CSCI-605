class Counter {
    private int count = 0;

    // Method to increment the counter
    public void increment() {
        count++;  // This operation is not atomic
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private Counter counter;

    // Constructor to set the shared Counter instance
    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();  // Increment the shared counter
        }
    }
}

public class RaceConditionExample {
    public static void main(String[] args) {
        Counter counter = new Counter(); // We want to count 1,000,000

        // n threads
        int n = 1000;
        CounterThread[] threadList = new CounterThread[n];
        for (int i = 0; i < threadList.length; i++) {
            threadList[i] = new CounterThread(counter);
            threadList[i].start();
        }

        // Wait for both threads to finish
        for (CounterThread counterThread : threadList) {
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

