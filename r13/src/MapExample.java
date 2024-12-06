import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        Map<List<String>, String> students = new HashMap<>();

        ArrayList<String> a = new ArrayList<>();
        a.add("MyKey1");
        a.add("MyKey2");

        ArrayList<String> b = new ArrayList<>();
        b.add("MyKey3");

//        ArrayList<String> c = new ArrayList<>();
//        c.add("MyKey2");
//        c.add("MyKey1");
        ArrayList<String> c = b;

        // Adding key-value pairs to the Map
        students.put(a, "Alice");
        students.put(b, "Bob");
        students.put(c, "Charlie");
        System.out.println("Initial Map: " + students);

        // try modifying the key
        a.add("MyKey4");

        // Accessing a value by its key
        System.out.println("Student with ID list `a`: " + students.get(a));

        a.remove("MyKey4");
        System.out.println("Student with ID list `a`: " + students.get(a));


        // Updating a value associated with a key
        students.put(c, "David"); // Updates the value for key 3
        System.out.println("Map after updating ID 3: " + students);

        // Removing a key-value pair
        students.remove(a); // Removes the entry with key 1
        System.out.println("Map after removing ID 1: " + students);

        // Checking if a key or value exists
        System.out.println("Does the Map contain key 2? " + students.containsKey(b));
        System.out.println("Does the Map contain value 'Alice'? " + students.containsValue("Alice"));

        // Iterating over the Map (Method 1: Using entrySet)
//        System.out.println("\nIterating using entrySet:");
//        for (Map.Entry<Integer, String> entry : students.entrySet()) {
//            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
//        }

        // Iterating over the Map (Method 2: Using keySet)
//        System.out.println("\nIterating using keySet:");
//        for (Integer key : students.keySet()) {
//            System.out.println("ID: " + key + ", Name: " + students.get(key));
//        }

        System.out.println("\nHash map values:");
        for (Object s: students.values()) {
            System.out.println(s.toString());
        }
        System.out.println("Is 'David' inside the list of all hash map values? " + students.values().contains("David"));

        // Clearing the Map
        students.clear();
        System.out.println("\nMap after clearing: " + students);
        System.out.println("Is the Map empty? " + students.isEmpty());
    }
}
