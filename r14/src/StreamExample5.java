
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample5 {
    public static void main(String[] args) {
        // Create a list of lists of integers
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        // Use flatMap to flatten the list of lists into a single stream of integers
        List<Integer> flattenedList = listOfLists.stream()
                // transform each element of a stream into a new stream, and then flatten (or merge) these streams into a single stream
                .flatMap(List::stream) // Flatten each inner list into the stream
                .collect(Collectors.toList()); // Collect into a list

        // Print the flattened list
        System.out.println("Flattened list: " + flattenedList);
    }
}
