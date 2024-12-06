import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExample2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);

        // Use a lambda expression to filter numbers greater than 15
        //List<Integer> filteredNumbers = numbers.stream().filter(num -> num > 15).collect(Collectors.toList());
        Stream<Integer> intStream = numbers.stream();
        Stream<Integer> filteredIntStream = intStream.filter(num -> num > 15);
        List<Integer> collectedList = filteredIntStream.collect(Collectors.toList());


        // Print the filtered list
        //filteredNumbers.forEach(num -> System.out.println(num));
        collectedList.forEach(num -> System.out.println(num));
    }
}
