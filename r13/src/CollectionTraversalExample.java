import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTraversalExample {
    public static void main(String[] args) {
        // Creating a collection of integers
        Collection<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // 1. Traversing using aggregate operations (Streams API)
        System.out.println("Traversing using aggregate operations:");
        numbers.stream().forEach(number -> System.out.println(number));

        // 2. Traversing using the for-each construct
        System.out.println("\nTraversing using the for-each construct:");
        for (Integer number : numbers) {
            System.out.println(number);
        }

        // 3. Traversing using an Iterator
        System.out.println("\nTraversing using an Iterator:");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            System.out.println(number);
        }
    }
}
