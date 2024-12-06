import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class StreamExample7 {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("David", 25)
        );

        // Use collect to convert the list into a Map, where the key is the person's name and the value is their age
        Map<String, Integer> nameToAgeMap = people.stream()
                .collect(Collectors.toMap(
                        Person::getName,     // Key: person's name
                        Person::getAge       // Value: person's age
                ));

        // Print the resulting map
        System.out.println(nameToAgeMap);
    }
}

