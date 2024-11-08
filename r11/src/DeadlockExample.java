class Resource {
    private String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class DeadlockThread extends Thread {
    private Resource resource1;
    private Resource resource2;

    public DeadlockThread(Resource resource1, Resource resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        // Lock on resource1
        synchronized (resource1) {
            System.out.println(Thread.currentThread().getName() + " locked " + resource1.getName());
            try {
                // Simulating some work with resource1
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " trying to lock " + resource2.getName());
            // Lock on resource2
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource2.getName());
            }
        }
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Resource resource1 = new Resource("Resource 1");
        Resource resource2 = new Resource("Resource 2");

        // Create two threads of the same class
        // Note that we are trying to simulate: each threads want both resource to work,
        //  so it must obtain both lock
        DeadlockThread threadA = new DeadlockThread(resource1, resource2);
        DeadlockThread threadB = new DeadlockThread(resource2, resource1); // Note the reversed order

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Done!");
    }
}
