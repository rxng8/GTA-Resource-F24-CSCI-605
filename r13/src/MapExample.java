import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        Map<Integer, String> students = new HashMap<>();

        // Adding key-value pairs to the Map
        students.put(1, "Alice");
        students.put(2, "Bob");
        students.put(3, "Charlie");
        System.out.println("Initial Map: " + students);

        // Accessing a value by its key
        System.out.println("Student with ID 2: " + students.get(2));

        // Updating a value associated with a key
        students.put(3, "David"); // Updates the value for key 3
        System.out.println("Map after updating ID 3: " + students);

        // Removing a key-value pair
        students.remove(1); // Removes the entry with key 1
        System.out.println("Map after removing ID 1: " + students);

        // Checking if a key or value exists
        System.out.println("Does the Map contain key 2? " + students.containsKey(2));
        System.out.println("Does the Map contain value 'Alice'? " + students.containsValue("Alice"));

        // Iterating over the Map (Method 1: Using entrySet)
        System.out.println("\nIterating using entrySet:");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }

        // Iterating over the Map (Method 2: Using keySet)
        System.out.println("\nIterating using keySet:");
        for (Integer key : students.keySet()) {
            System.out.println("ID: " + key + ", Name: " + students.get(key));
        }

        // Clearing the Map
        students.clear();
        System.out.println("\nMap after clearing: " + students);
        System.out.println("Is the Map empty? " + students.isEmpty());
    }
}
