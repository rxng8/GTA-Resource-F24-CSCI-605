import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample3 {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        // Use Stream API to group strings by their lengths
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        // Print the result
        groupedByLength.forEach((length, group) ->
                System.out.println("Length " + length + ": " + group)
        );
    }
}
