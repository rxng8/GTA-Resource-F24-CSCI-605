class JoinExample implements Runnable {
    private String taskName;

    // Constructor to set the task name
    public JoinExample(String name) {
        this.taskName = name;
    }

    // Implement the run method
    @Override
    public void run() {
        System.out.println(taskName + " is starting.");

        // Sample task: Print numbers from 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " prints: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(taskName + " was interrupted.");
            }
        }

        System.out.println(taskName + " has finished.");
    }

    // Main method to demonstrate join()
    public static void main(String[] args) {
        // Create instances of MyRunnableTask
        JoinExample task1 = new JoinExample("Task 1");
        JoinExample task2 = new JoinExample("Task 2");

        // Wrap each task in a Thread
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for thread1 to finish before moving to the next line
            thread1.join();
            System.out.println("Task 1 completed. Now waiting for Task 2.");

            // Wait for thread2 to finish
            thread2.join();
            System.out.println("Task 2 completed. Both tasks are done.");

        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Main thread ends.");
    }
}