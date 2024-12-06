import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Sort the list using a lambda expression
        Collections.sort(names, (a, b) -> a.compareTo(b));

        // Print the sorted list
        names.forEach(name -> System.out.println(name));
    }
}
