import java.io.*;
import java.util.Scanner;

// The Serializable class that will be saved to a file
class Person2 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class CombinedExample1 {

    public static void main(String[] args) {
        // Check if we have the right number of arguments
        if (args.length < 2) {
            System.err.println("Please provide name and age as arguments.");
            System.exit(1);
        }

        try {
            // Parse name and age from args
            String name = args[0];
            int age = Integer.parseInt(args[1]);

            // Create a new Person object
            Person2 person = new Person2(name, age);

            // Serialize the Person object to a file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
                oos.writeObject(person);
            }

            // Print the object to System.out
            System.out.println("Serialized Object: " + person.toString());
        } catch (NumberFormatException e) {
            System.err.println("The age argument must be an integer.");
            e.printStackTrace(System.err);
        } catch (IOException e) {
            System.err.println("An error occurred while saving the object.");
            e.printStackTrace(System.err);
        }
    }
}
