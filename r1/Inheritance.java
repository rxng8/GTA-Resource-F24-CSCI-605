/**
 * StyleExample serves as an example of recommended Java coding style.
 *
 * @author Anne Author, axa1234@rit.edu
 * @author Sumhel Per, spp1234@rit.edu
 */

// https://www.w3schools.com/java/java_inheritance.asp
class Vehicle {
    protected String brand = "Ford";        // Vehicle attribute
    public void honk() {                    // Vehicle method
        System.out.println("Tuut, tuut!");
    }
}

class Car extends Vehicle {
    protected String modelName = "Mustang";    // Car attribute

}

public class Inheritance {

    public static void main(String[] args) {

        // Create a myCar object
        Car myCar = new Car();
        // Call the honk() method (from the Vehicle class) on the myCar object
        myCar.honk();
        // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
        System.out.println(myCar.brand + " " + myCar.modelName);

        Vehicle myVehicle = new Car();
        myVehicle.honk();
        // this will cause error
//        System.out.println(myVehicle.brand + " " + myVehicle.modelName);
        System.out.println(myVehicle.brand);

        /**
         * In general: if B extends A (B is a subclass of A)
         * A x = new A();
         *  x is an instantiation of A and of type A.
         * A x = new B();
         *  x is an instantiation of B and of type A.
         *  x.someMethod() => the method of B will be called, but not the variables
         *
         */

//        Again, error. parent class initiated object can not have children type
//        Car c = new Vehicle();



    }
}