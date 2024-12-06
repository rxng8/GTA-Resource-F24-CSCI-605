
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class LambdaExample3 {
    public static void main(String[] args) {
        // Using a lambda expression to implement the Greeting interface
        Greeting greeting = name -> System.out.println("Hello, " + name + "!");

        // Call the lambda function
        greeting.sayHello("Alice");
        greeting.sayHello("Bob");
    }
}
