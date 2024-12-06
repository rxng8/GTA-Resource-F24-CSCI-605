import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamExample6 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 1, 4);

        // Use reduce to find the maximum value in the list
        Optional<Integer> max = numbers.stream()
                .reduce((a, b) -> a > b ? a : b); // Compare two elements and return the larger one

        // Print the result
        max.ifPresent(maxValue -> System.out.println("Maximum value: " + maxValue));
    }
}
