
class Transporter {

    public int capacity;

    public Transporter(int capacity) {
        this.capacity = capacity;
    }

    public void move(double distance) {
        System.out.println("Moved " + distance + " units!");
    }
}

class Vehicle extends Transporter {

    public String machineType;

    // constructor for child class is required if parent class also have constructor
    public Vehicle(int capacity, String machineType) {
        super(capacity);
        this.machineType = machineType;
    }

    public void honk() {
        System.out.println("Vehicle honks.");
    }

    @Override
    public void move(double distance) {
        super.move(distance + 2.0);
    }
}

class Animal extends Transporter {

    public String animalType;

    public Animal(int capacity, String animalType) {
        super(capacity);
        this.animalType = animalType;
    }

    public void makeSound() {
        System.out.println("Animal makes sound.");
    }

//    public void makeSound(boolean humanSlap) {
//        System.out.println("None");
//    }
}

class Car extends Vehicle {

    public String carModel;

    public Car(int capacity, String machineType, String carModel) {
        super(capacity, machineType);
        this.carModel = carModel;
    }

    @Override
    public void honk() {
        System.out.println("Car: Beep Beep");
    }
}

class Motorbike extends Vehicle {

    public String motorbikeModel;

    public Motorbike(int capacity, String machineType, String motorbikeModel) {
        super(capacity, machineType);
        this.motorbikeModel = motorbikeModel;
    }

    @Override
    public void honk() {
        System.out.println("Motorbike: Bip Bip");
    }
}

class Horse extends Animal {

    public String horseType;

    public Horse(int capacity, String animalType, String horseType) {
        super(capacity, animalType);
        this.horseType = horseType;
    }

    @Override
    public void makeSound() {
        System.out.println("Horse: Hee Hee");
    }

//    @Override
    public void makeSound(boolean humanSlap) {
        System.out.println(humanSlap ? "Horse: Heeeeeeeeeeeeeeeeee": "Horse: Hee Hee");
    }

}

public class InheritanceDriver {

    public static void main(String[] args) {

        // Compile Time
        Animal horse1;

        // Run Time
        horse1 = new Horse(3, "4 legs", "dragon horse");
        horse1.makeSound();

        /**
         * This will not work, because at compile time,
         * object `horse1` does not have the method signature for this method!
         */
//        horse1.makeSound(true);

        /*************************************/
        Horse horse2 = new Horse(3, "4 legs", "crocodile horse");
        horse2.makeSound();
        horse2.makeSound(true);

        /*************************************/
        // Compile Time
        Car car1;

        // Run Time
        car1 = new Car(4, "4 wheels", "Volvo");
        car1.move(4);
        //car1.honk(); // Again, this does not work.

        /**
         * The reason why we would want to say Transporter = new Car()
         *  is for polymorphism.
         */

        // This will not work
//        Car[] allTransporters = new Car[]{
//                new Car(5, "4 wheels", "BMW"),
//                new Horse(2, "4 legs", "dragon horse")
//        };

        Transporter[] allTransporters = new Transporter[]{
                new Car(5, "4 wheels", "BMW"),
                new Horse(2, "4 legs", "dragon horse")
        };

        for (Transporter t : allTransporters) {
            t.move(5.4);
        }

        Vehicle[] allVehicles = new Vehicle[]{
                new Car(5, "4 wheels", "BMW"),
                new Motorbike(3, "2 wheels", "Vespa")
        };

        for (Vehicle v : allVehicles) {
            v.honk(); // Example of polymorphism
        }

    }
}