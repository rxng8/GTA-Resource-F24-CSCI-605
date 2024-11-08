
import java.util.LinkedList;

class SharedResource {
    private final LinkedList<Integer> list = new LinkedList<>();
    private final int capacity;

    public SharedResource(int capacity) {
        this.capacity = capacity;
    }

    // Method for producing items
    public synchronized void produce(int value) throws InterruptedException {
        while (list.size() == capacity) {
            System.out.println("Producer is waiting: List is full.");
            wait(); // Wait until space is available
        }
        list.add(value); // producing
        System.out.println("Produced: " + value);
        notify(); // Notify the consumer that a new item is available
    }

    // Method for consuming items
    public synchronized int consume() throws InterruptedException {
        while (list.isEmpty()) {
            System.out.println("Consumer is waiting: List is empty.");
            wait(); // Wait until an item is available
        }
        int value = list.removeFirst(); // consuming the first value
        System.out.println("Consumed: " + value);
        notify(); // Notify the producer that space is available
        return value;
    }
}

class Producer extends Thread {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                resource.produce(i);
                Thread.sleep(500); // Simulate time taken to produce an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private final SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                resource.consume();
                Thread.sleep(1000); // Simulate time taken to consume an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource(5); // Capacity of the shared resource
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        Consumer consumer2 = new Consumer(resource);

        producer.start();
        consumer.start();
        consumer2.start();

        try {
            producer.join();
            consumer.join();
            consumer2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

    }
}
