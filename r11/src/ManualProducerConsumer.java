import java.util.ArrayList;
import java.util.List;

class ManualProducerConsumer {
    // Shared resource (a list of numbers)
    private static List<Integer> sharedList = new ArrayList<>();
    private static final int MAX_SIZE = 10;  // Max size of the list

    // Flags to indicate when the producer and consumer can operate
    private static boolean producerCanProduce = true;
    private static boolean consumerCanConsume = false;

    public static void main(String[] args) {
        // Create producer and consumer threads
        Thread producer = new Thread(new Producer("Producer-1"));
        Thread producer2 = new Thread(new Producer("Producer-2"));
        Thread consumer = new Thread(new Consumer("Consumer-1"));
        Thread consumer2 = new Thread(new Consumer("Consumer-2"));
        Thread consumer3 = new Thread(new Consumer("Consumer-3"));

        producer.start();
        producer2.start();
        consumer.start();
        consumer2.start();
        consumer3.start();
    }

    static class Producer implements Runnable {

        String name;

        public Producer(String name) {this.name = name;}

        @Override
        public void run() {
            int number = 1;
            while (true) {
                // Check if the producer can produce
                while (!producerCanProduce) {
                    // Polling mechanism: check if the producer can proceed
                    try {
                        Thread.sleep(10);  // Sleep briefly to avoid busy-waiting
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                // Produce a number and add it to the list
                synchronized (sharedList) {
                    if (sharedList.size() < MAX_SIZE) {
                        sharedList.add(number++);
                        System.out.println(this.name + " produced: " + (number - 1));
                    }
                }

                // Set flags: Now the producer cannot produce and the consumer can consume
                producerCanProduce = false;
                consumerCanConsume = true;

                // Sleep to simulate the time taken for producing an item
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        String name;

        public Consumer(String name) {this.name = name;}

        @Override
        public void run() {
            while (true) {
                // Check if the consumer can consume
                while (!consumerCanConsume) {
                    // Polling mechanism: check if the consumer can proceed
                    try {
                        Thread.sleep(10);  // Sleep briefly to avoid busy-waiting
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                // Consume the first number from the list
                synchronized (sharedList) {
                    if (!sharedList.isEmpty()) {
                        int number = sharedList.remove(0);
                        System.out.println(this.name + " consumed: " + number);
                    }
                }

                // Set flags: Now the consumer cannot consume and the producer can produce
                consumerCanConsume = false;
                producerCanProduce = true;

                // Sleep to simulate the time taken for consuming an item
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
