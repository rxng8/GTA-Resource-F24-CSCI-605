import java.lang.reflect.Constructor;

class Person2 {
    private String name;
    private int age;

    // Constructor
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }
}

public class DynamicObjectCreationExample {
    public static void main(String[] args) throws Exception {
        // Class name and constructor parameters are dynamic
        String className = "Person2";  // Name of the class to be dynamically instantiated
        String nameParam = "Alice";   // Constructor parameter: name
        int ageParam = 25;            // Constructor parameter: age

        // Load the class dynamically
        Class<?> clazz = Class.forName(className);

        // Get the constructor with matching parameter types (String, int)
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);

        // Dynamically create an object using the constructor
        Object personObj = constructor.newInstance(nameParam, ageParam);

        // Invoke the introduce method dynamically
        personObj.getClass().getMethod("introduce").invoke(personObj);
    }
}
