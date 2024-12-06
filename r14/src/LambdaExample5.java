import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExample5 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);

        // Sort the list in descending order using a lambda expression
        Collections.sort(numbers, (a, b) -> b - a);

        // Print the sorted list
        numbers.forEach(num -> System.out.println(num));
    }
}
