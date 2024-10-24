import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Unique identifier for the class

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString method to display the object
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class SerializableExample {
    public static void main(String[] args) {
        String filePath = "SerializableExample.ser";

        // Creating an instance of Person
        Person person = new Person("John Doe", 30);

        // Serializing the object to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(person);
            System.out.println("Object has been serialized: " + person);
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }

        // Deserializing the object from the file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Object has been deserialized: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
    }
}
