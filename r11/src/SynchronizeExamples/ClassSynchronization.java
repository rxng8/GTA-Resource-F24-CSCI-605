package SynchronizeExamples;


class Counter {
    private static int count = 0;

    // Static method synchronization
    public static synchronized void incrementStatic() {
        // This method is synchronized at the class level.
        count++;
        System.out.println(Thread.currentThread().getName() + " - Increment Static: " + count);
    }

    // Class object synchronization using synchronized block
    public static void incrementWithClassSync() {
        synchronized (Counter.class) {
            // This block is synchronized at the class level.
            count++;
            System.out.println(Thread.currentThread().getName() + " - Increment Class Sync: " + count);
        }
    }

    public static int getCount() {
        return count;
    }
}

class LoopCounterThreadWithStatic extends Thread {

    private String threadName;

    // Constructor to set the thread name
    public LoopCounterThreadWithStatic(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Counter.incrementStatic();
        }
    }
}

class LoopCounterThreadWithClassObj extends Thread {

    private String threadName;

    // Constructor to set the thread name
    public LoopCounterThreadWithClassObj(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Counter.incrementWithClassSync();
        }
    }
}

public class ClassSynchronization {
    public static void main(String[] args) {
        // Creating multiple threads
        LoopCounterThreadWithStatic thread1 = new LoopCounterThreadWithStatic("Thread-0");
        LoopCounterThreadWithStatic thread2 = new LoopCounterThreadWithStatic("Thread-1");
        LoopCounterThreadWithClassObj thread3 = new LoopCounterThreadWithClassObj("Thread-2");

        // Starting threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final count value
        System.out.println("Final Count: " + Counter.getCount());
    }
}
