/**
 * StyleExample serves as an example of recommended Java coding style.
 *
 * @author Anne Author, axa1234@rit.edu
 * @author Sumhel Per, spp1234@rit.edu
 */
public class Syntax {

    static void myMethod(String name) {
        /**
         * Method Scope
         *
         * Variables declared directly inside a method are available anywhere
         *  in the method following the line of code in which they were declared:
         */
        System.out.println("Hello, " + name);
    }

    // Recursion
    public static int sum(int k) {
        /**
         * SUMMING ALL NUMBER FROM 0 TO k
         * Adding two numbers together is easy to do, but adding a range
         *  of numbers is more complicated. In the following example,
         *  recursion is used to add a range of numbers together by breaking
         *  it down into the simple task of adding two numbers
         *
         * 10 + sum(9)
         * 10 + ( 9 + sum(8) )
         * 10 + ( 9 + ( 8 + sum(7) ) )
         * ...
         * 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + sum(0)
         * 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + 0
         *
         *
         *  Be careful of stack overflow
         */
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }

    static class Car {

        private String model;
        private int numWheels;

        // Constructor: called every calling
        public Car(String model, int numWheels) {
            this.model = model;
            this.numWheels = numWheels;
        }

        public void run(double miles) {
            System.out.println("Car has run " + miles + " miles.");
        }
    }


    public static void main(String[] args) {

        // double quote with text, single quote with character
//        System.out.println("Hello world!");

        // print number
//        System.out.println(4);

        // <- this is a comment
        /**
         * This is a block comment
         */
        /**
         *
         */
        // lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum
        // lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum
        /**
         * lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum
         *  lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum
         */
//        System.out.println("line with comment"); // comment here

        // ----- Variables ------- //
        /**
         * common: int, String, float, char, boolean, double
         * primitive: byte, short, int, long, float, double, boolean and char
         * Non-primitive data types - such as String, Arrays and Classes, etc.
         * `type variableName = value;`
         */
//        int a = 0;
//        int b = 3;
//        float c = 3;
//        double c = 4.3d;
//        String d = "s"; // not "s", those are different
//        String e = "hello world";
//        boolean f = true;
//        if (f) System.out.println("this got printed");
//        System.out.println(b);
//        System.out.println(c + b);
//        System.out.println(c + d); // 119
//        System.out.println(c + e); // string
//        System.out.println(e + e); // string
//        System.out.println(a + b);
//        System.out.println(3.);

        // Casting
//        int g = 7;
//        float h = (float) g;
//        double i = 14.4d;
//        int k = (int) i;

        // Operator, `+`, `-`, `*`, `/`, `//`, `%`, `++`, `--`. Advanced: `>>`, `<<`, `&`, `|`, `^`
//        float l = g + h;
//        float m = g - h;
//        int n = 1;
//        System.out.println(n++);
//        System.out.println(n);
//        n = 1;
//        System.out.println(++n);
//        System.out.println(n);
//        int a = 3;
//        int b = 2;
//        System.out.println(a / b); // this is not rounding, but omitting the floating point

//        float g = 2
//        System.out.println();

        // Addition assignment
        // `+=`, `-=`, `*=`, `/=`, `//=`, `%=`. Advanced: `>>=`, `<<=`, `&=`, `|=`, `^=`
//        int a1 = 3;
//        int a = 3;
//        a += 2; // a = a + 2;
//        a1 += 2;
//        System.out.println(a1);
//        int a2 = 3;
//        a2 = a2 + 3;
//        System.out.println(a2);

        // Boolean expression
//        System.out.println(3 > 4);
//        System.out.println(4 + 2 == 6);
//        boolean b1 = 3 > 4;
//        >, <, ==
//        int s = 3;
//        boolean b = (3 == 4);
//        System.out.println(b);

        // If else logics
        /**
         * if (boolean statement) {
         *     body
         * } else if (boolean statement) {
         *    body
         * } else if () {
         *     body
         *
         * } else {
         *     body
         * }
         */
        // Short hand if else: `variable = (condition) ? expressionTrue :  expressionFalse;`
//        int time = 20;
//        if (time < 18) {
//            System.out.println("Good day.");
//        } else {
//            System.out.println("Good evening.");
//        }
//        System.out.println(time < 18 ? "Good day." : "Good evening.");

        // For:
        /**
         * for (statement 1; statement 2; statement 3) {
         *   // code block to be executed
         * }
         * Statement 1 is executed (one time) before the execution of the code block.
         * Statement 2 defines the condition for executing the code block.
         * Statement 3 is executed (every time) after the code block has been executed.
         *
         * TL;DR:
         *      1: initial value of something
         *      2: the limit of that something
         *      3: how to update that something after each loop is done
         */
//        for (int i = 0; i < 5; i = i + 1) {
//            System.out.println(i);
//        }
//        for (int i2 = 0; i2 <= 10; i2 = i2 + 2) {
//            System.out.println(i2);
//        }

        // Nested
        // Outer loop
//        for (int i3 = 1; i3 <= 2; i3++) {
//            System.out.println("Outer: " + i3); // Executes 2 times
//            // Inner loop
//            for (int j3 = 1; j3 <= 3; j3++) {
//                System.out.println(" Inner: " + j3); // Executes 6 times (2 * 3)
//            }
//        }

        // For each
        /**
         * for (type variableName : arrayName) {
         *   // code block to be executed
         * }
         */
//        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"}; // <- array
//        for (String c1 : cars) {
//            System.out.println(c1);
//        }


        // Break
//        for (int i5 = 0; i5 < 10; i5++) {
//            if (i5 == 4) {
//                break;
//            }
//            System.out.println(i5);
//        }

        // continue
//        for (int i6 = 0; i6 < 10; i6++) {
//            if (i6 == 4) {
//                continue;
//            }
//            System.out.println(i);
//        }

        // Array
//        int[] myNum = {10, 20, 30, 40};
//        String[] cars2 = {"Volvo", "BMW", "Ford", "Mazda"};
//        System.out.println(cars2[0]);
//        cars[0] = "Opel";

        // Method
//        myMethod("World");
//        myMethod("CSCI 605");

        // Class
//        Car car = new Car("Tesla", 4);
//        System.out.println(car.model); // private <- still can access inside a class
//        car.run(39);



    }
}