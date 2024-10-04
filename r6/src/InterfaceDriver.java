/**
 * We will model:
 *     Animals that fly naturally (e.g., birds).
 *     Animals that use echolocation while flying (e.g., bats).
 *     Mechanical entities that fly artificially (e.g., airplanes).
 */
// Interface for Flyable animals and objects
interface Flyable {
    void fly();

    // From JAVA 8: Optional Override
    default void takeOff() {
        System.out.println("Taking off into the sky...");
    }

    // Static method! Think about why we can put it here!
    static void checkWeather() {
        System.out.println("Weather is clear for flying.");
    }
}

// Interface for animals that use wings to fly
interface WingedFlyer extends Flyable {
    // Specific method for flapping wings
    void flapWings();

    // From JAVA 8: Optional Override
    default void land() {
        System.out.println("Landing smoothly using wings...");
    }
}

// Interface for echolocation, used by bats
interface EcholocationFlyer extends Flyable {
    void useEcholocation();

    // From JAVA 8: Optional Override
    default void nightFly() {
        System.out.println("Flying at night using echolocation...");
    }
}

// Interface for mechanical flying systems (e.g., airplanes)
interface MechanicalFlyer extends Flyable {
    void startEngine();

    // Override the default takeOff method for mechanical flyers
    @Override
    default void takeOff() {
        System.out.println("Starting engine and taking off using thrust...");
    }

    // Specific method for flying in autopilot mode
    default void autoPilot() {
        System.out.println("Flying in autopilot mode...");
    }
}

// Birds only have WingedFlyer inteface
class Bird implements WingedFlyer {
    @Override
    public void fly() {
        System.out.println("Bird is flying...");
    }

    @Override
    public void flapWings() {
        System.out.println("Bird is flapping its wings...");
    }
}


// Rememebr: Bat implements both WingedFlyer and EcholocationFlyer because it flies with wing and echo
class Bat implements WingedFlyer, EcholocationFlyer {

    @Override
    public void fly() {
        System.out.println("Bat is flying...");
    }

    @Override
    public void flapWings() {
        System.out.println("Bat is flapping its wings...");
    }

    @Override
    public void useEcholocation() {
        System.out.println("Bat is using echolocation...");
    }

    // Bats use both echolocation and wings for specific night flying
    @Override
    public void nightFly() {
        EcholocationFlyer.super.nightFly(); // no interface object? here is how you do it! you call the super object
        System.out.println("Bat is also flapping its wings while night flying...");
    }
}

// Class for Airplanes that implements MechanicalFlyer
class Airplane implements MechanicalFlyer {

    @Override
    public void fly() {
        System.out.println("Airplane is flying...");
    }

    @Override
    public void startEngine() {
        System.out.println("Airplane engine started.");
    }

    @Override
    public void takeOff() {
        // Using takeoff from MechanicalFlyer
        MechanicalFlyer.super.takeOff(); // Same with interface object usage in the Bat class
    }
}

// Main class to test the functionality
public class InterfaceDriver {
    public static void main(String[] args) {
        // Using Bird
        Bird bird = new Bird();
        bird.takeOff();
        bird.flapWings();
        bird.fly();
        bird.land();
        Flyable.checkWeather(); // Using static method from Flyable

        System.out.println();

        // Using Bat
        Bat bat = new Bat();
        bat.takeOff();
        bat.nightFly();    // Combining echolocation and flying behavior
        bat.fly();
        bat.flapWings();
        bat.useEcholocation();

        System.out.println();

        // Using Airplane
        Airplane airplane = new Airplane();
        Flyable.checkWeather();
        airplane.startEngine();
        airplane.takeOff();
        airplane.autoPilot();
        airplane.fly();
    }
}