import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> cities = new ArrayList<>();

        // Adding elements to the ArrayList
        cities.add("New York");
        cities.add("London");
        cities.add("Tokyo");
        cities.add("Sydney");
        System.out.println("Initial ArrayList: " + cities);

        // Accessing elements
        System.out.println("First city: " + cities.get(0));
        System.out.println("Second city: " + cities.get(1));

        // Updating an element
        cities.set(2, "Paris");
        System.out.println("ArrayList after updating Tokyo to Paris: " + cities);

        // Removing an element by index
        cities.remove(1);
        System.out.println("ArrayList after removing London: " + cities);

        // Removing an element by value
        cities.remove("Sydney");
        System.out.println("ArrayList after removing Sydney: " + cities);

        // Checking if the ArrayList contains a specific element
        if (cities.contains("New York")) {
            System.out.println("New York is in the list.");
        }

        // Iterating through the ArrayList using a for-each loop
        System.out.println("Iterating using for-each loop:");
        for (String city : cities) {
            System.out.println(city);
        }

        // Iterating through the ArrayList using a for loop
        System.out.println("Iterating using for loop:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }

        // Clearing the ArrayList
        cities.clear();
        System.out.println("ArrayList after clearing: " + cities);
        System.out.println("Is the ArrayList empty? " + cities.isEmpty());
    }
}
