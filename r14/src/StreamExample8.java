import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample8 {
    public static void main(String[] args) {
        // Create a list with some duplicate elements
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 7, 8, 5);

        // Use distinct to remove duplicates from the list
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()  // Remove duplicates
                .collect(Collectors.toList());  // Collect the results into a list

        // Print the unique numbers
        System.out.println("Unique numbers: " + uniqueNumbers);
    }
}
