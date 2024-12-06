import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample9 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use skip to skip the first 3 elements and limit to take only the next 4 elements
        List<Integer> result = numbers.stream()
                .skip(3)  // Skip the first 3 elements
                .limit(4) // Take only the next 4 elements
                .collect(Collectors.toList()); // Collect into a list

        // Print the result
        System.out.println("Result after skip and limit: " + result);
    }
}
