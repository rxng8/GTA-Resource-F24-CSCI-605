// Java Program to Implement
// Method Overloading
import java.io.*;


class Parent {
    public void say(String text) {
        System.out.println(text);
    }
}

class Child extends Parent {
    public void say(String text1, String text2) {
        System.out.println(text1 + text2);
    }
}

public class Overloading {

    static int add(int a, int b) { return a + b; }

    static int add(int a, int b, int c)
    {
        return a + b + c;
    }

    // Main Function
    public static void main(String[] args)
    {
        System.out.println("add() with 2 parameters");
        // Calling function with 2 parameters
        System.out.println(add(4, 6));

        System.out.println("add() with 3 parameters");
        // Calling function with 3 Parameters
        System.out.println(add(4, 6, 7));

        // Different class overloading
        Parent o1 = new Parent();
        o1.say("Hello, this is type Parent with Parent initializer");
        Parent o2 = new Child();
        o2.say("Hello, this is type Parent with Child initializer");
        //o2.say("Hello, this is type Parent with Child initializer", ". This is text 2"); // This will not work
        Child o3 = new Child();
        o3.say("Hello, this is type Child with Child initializer");
        o3.say("Hello, this is type Child with Child initializer", ". This is text 2");
    }
}