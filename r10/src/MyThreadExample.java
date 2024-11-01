public class MyThreadExample extends Thread {
    private String threadName;

    // Constructor to set the thread name
    public MyThreadExample(String name) {
        this.threadName = name;
    }

    // Override the run method
    @Override
    public void run() {
        System.out.println(threadName + " is starting.");

        // Sample task: Print numbers from 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " prints: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }

        System.out.println(threadName + " has finished.");
    }

    // Main method to start the custom threads
    public static void main(String[] args) {
        // Create two instances of MyCustomThread
        MyThreadExample thread1 = new MyThreadExample("Thread 1");
        MyThreadExample thread2 = new MyThreadExample("Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
