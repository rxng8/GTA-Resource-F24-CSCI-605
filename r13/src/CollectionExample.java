import java.util.ArrayList;
import java.util.Collection;

public class CollectionExample {
    public static void main(String[] args) {
        // Creating a Collection using ArrayList
        Collection<String> fruits = new ArrayList<>();

        // Adding elements to the Collection
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("Initial Collection: " + fruits);

        // Checking if a specific element is present
        if (fruits.contains("Banana")) {
            System.out.println("Banana is in the collection.");
        }

        // Removing an element
        fruits.remove("Apple");
        System.out.println("After removing Apple: " + fruits);

        // Getting the size of the Collection
        System.out.println("Collection size: " + fruits.size());

        // Iterating through the Collection
        System.out.println("Fruits in the collection:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Clearing the Collection
        fruits.clear();
        System.out.println("Collection after clearing: " + fruits);
        System.out.println("Is the collection empty? " + fruits.isEmpty());
    }
}
