

// Interface: Vehicle. Naming: behavior
interface RunnableVehicle {
    // Abstract method (implicitly public and abstract)
    void move();

    // Default method (from Java 8)
    default void fuelUp() {
        System.out.println("Filling up the vehicle with fuel.");
    }

    // Static method (from Java 8)
    static void startEngine() {
        System.out.println("Starting the vehicle's engine...");
    }
}

// Abstract Class: AbstractCar
abstract class AbstractCar {
    // Field (state)
    String brand;

    // Constructor
    public AbstractCar(String brand) {
        this.brand = brand;
    }

    // Abstract method
    abstract void drive();

    // Non-abstract method
    void stop() {
        System.out.println("Stopping the car.");
    }
}

// Concrete Class: Tesla
class Tesla extends AbstractCar implements RunnableVehicle {
    public Tesla(String brand) {
        super(brand);
    }

    // Implementing abstract method from AbstractCar abstract class
    @Override
    void drive() {
        System.out.println(brand + " is driving.");
    }

    // Implementing abstract method from VehicleRunnable interface
    @Override
    public void move() {
        System.out.println(brand + " is moving silently.");
    }
}

public class AbstractClassAndInheritanceDriver {
    public static void main(String[] args) {

        /**
         * When we talk about abstract classes we are defining characteristics of an object type;
         *  specifying what an object is.
         *
         * When we talk about an interface and define capabilities that we promise to provide,
         *  we are talking about establishing a contract about what the object can do.
         */

        // Static method call from Interface
        RunnableVehicle.startEngine();

        // Creating object of concrete class Tesla
        Tesla myTesla = new Tesla("Tesla");

        // Calling methods
        myTesla.drive();  // From abstract class AbstractCar
        myTesla.move();   // From interface VehicleRunnable
        myTesla.fuelUp(); // Default method from interface VehicleRunnable
        myTesla.stop();   // Non-abstract method from abstract class AbstractCar
    }
}
