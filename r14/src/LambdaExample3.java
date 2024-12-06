
@FunctionalInterface
interface Greeting {
//    void sayHello(String name);
    void sayGoodBye2People(String name1, String name2);
}

public class LambdaExample3 {
    public static void main(String[] args) {
        // Using a lambda expression to implement the Greeting interface
        Greeting greeting = (meow, meow2) -> System.out.println("Goodbye, " + meow + " and " + meow2 + "!");

        // Call the lambda function
        greeting.sayGoodBye2People("Alice", "Bob");
        greeting.sayGoodBye2People("Charlie", "Doe");
    }
}
