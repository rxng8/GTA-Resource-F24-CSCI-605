import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit 5 tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executorService.submit(new Task(taskId));
        }

        // Shutdown the executor service
        executorService.shutdown();
    }
}

// Custom Runnable class for tasks
class Task implements Runnable {
    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
            // Simulate work by sleeping for a random amount of time
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
