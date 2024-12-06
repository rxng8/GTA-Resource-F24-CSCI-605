
public class LambdaExample4 {
    public static void main(String[] args) {
        // Using a lambda expression to define a Runnable
        Runnable task = () -> {
            System.out.println("Task is running!");
            System.out.println("Hello from the lambda!");
        };

        // Creating a thread and passing the Runnable
        Thread thread = new Thread(task);

        // Start the thread
        thread.start();
    }
}
