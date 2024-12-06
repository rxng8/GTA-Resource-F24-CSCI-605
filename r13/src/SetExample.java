import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // Creating a Set of Strings
        // both works
        Collection<String> fruits = new HashSet<>();
//        Set<String> fruits = new HashSet<>();

        // Adding elements to the Set
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple"); // Duplicate, will not be added
        System.out.println("Set after adding elements: " + fruits);

        // Checking if an element is in the Set
        System.out.println("Does the Set contain 'Banana'? " + fruits.contains("Banana"));

        // Removing an element from the Set
        fruits.remove("Cherry");
        System.out.println("Set after removing 'Cherry': " + fruits);

        // Iterating through the Set using a for-each loop
        System.out.println("Iterating using for-each loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Checking the size of the Set
        System.out.println("Size of the Set: " + fruits.size());

        // Clearing all elements from the Set
        fruits.clear();
        System.out.println("Set after clearing: " + fruits);
        System.out.println("Is the Set empty? " + fruits.isEmpty());
    }
}
