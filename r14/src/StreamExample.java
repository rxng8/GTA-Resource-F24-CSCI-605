import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Filter names starting with 'A', convert to uppercase, and collect into a new list
        List<String> filteredNames = names.stream() // "Alice", "Bob", "Charlie", "David"
                .filter(name -> name.startsWith("A")) // "Alice"
                .map(String::toUpperCase) // "ALICE"
                .collect(Collectors.toList()); // ["ALICE"]

        // Print the filtered names
        filteredNames.forEach(System.out::println);
    }
}