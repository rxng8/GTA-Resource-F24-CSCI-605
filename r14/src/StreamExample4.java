import java.util.List;
import java.util.stream.IntStream;

public class StreamExample4 {
    public static void main(String[] args) {
        // Create a list of numbers from 1 to 1,000,000
        int start = 1, end = 1_000_000;

        // Use a parallel stream to calculate the sum of squares
        long sumOfSquares = IntStream.rangeClosed(start, end) // stream of numbers: 1, 2, 3, ..., 1_000_000
                .parallel() // Enable parallel processing
                .map(n -> n * n) // Calculate square of each number
                .asLongStream() // Convert to long stream to avoid overflow
                .sum(); // Sum all squared values

        // Print the result
        System.out.println("Sum of squares from " + start + " to " + end + " is: " + sumOfSquares);
    }
}
