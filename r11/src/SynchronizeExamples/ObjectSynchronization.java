package SynchronizeExamples;

class Counter2 {
    private int count = 0;
    private final Object lock = new Object(); // Custom lock object for variable synchronization

    // Instance method synchronization
    public synchronized void incrementInstanceMethod() {
        // This method is synchronized at the object level.
        count++;
        System.out.println(Thread.currentThread().getName() + " - Increment Instance Method: " + count);
    }

    // Variable synchronization using synchronized block
    public void incrementWithVariableSync() {
        synchronized (lock) {
            // This block is synchronized on the 'lock' object.
            count++;
            System.out.println(Thread.currentThread().getName() + " - Increment Variable Sync: " + count);
        }
    }

    public int getCount() {
        return count;
    }
}

class LoopCounterThreadWithMethod extends Thread {

    private String threadName;
    Counter2 counter;

    // Constructor to set the thread name
    public LoopCounterThreadWithMethod(Counter2 counter, String name) {
        this.threadName = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.incrementInstanceMethod();
        }
    }
}

class LoopCounterThreadWithLock extends Thread {

    private String threadName;
    Counter2 counter;

    // Constructor to set the thread name
    public LoopCounterThreadWithLock(Counter2 counter, String name) {
        this.threadName = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.incrementWithVariableSync();
        }
    }
}

public class ObjectSynchronization {
    public static void main(String[] args) {
        Counter2 counter = new Counter2();

        LoopCounterThreadWithMethod thread1 = new LoopCounterThreadWithMethod(counter, "Thread-0");
        LoopCounterThreadWithLock thread2 =  new LoopCounterThreadWithLock(counter, "Thread-1");
        LoopCounterThreadWithLock thread3 =  new LoopCounterThreadWithLock(counter, "Thread-2");

        // Starting threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for threads to complete
        // Join is very important here, try commenting out the join
        // to see if it still works correctly
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final count value
        System.out.println("Final Count: " + counter.getCount());
    }
}
