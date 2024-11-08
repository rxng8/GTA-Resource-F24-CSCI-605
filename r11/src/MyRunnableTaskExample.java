public class MyRunnableTaskExample implements Runnable {
    private String taskName;

    // Constructor to set the task name
    public MyRunnableTaskExample(String name) {
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

    // Main method to start threads using Runnable
    public static void main(String[] args) {
        // Create two instances of MyRunnableTask
        MyRunnableTaskExample task1 = new MyRunnableTaskExample("Task 1");
        MyRunnableTaskExample task2 = new MyRunnableTaskExample("Task 2");

        // Wrap each task in a Thread and start the threads
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
