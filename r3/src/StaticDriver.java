/**
 * StyleExample serves as an example of recommended Java coding style.
 *
 * @author Anne Author, axa1234@rit.edu
 * @author Sumhel Per, spp1234@rit.edu
 */

class Elevator {
    private int currentFloor;
    private boolean isOpen;
    private int maxCapacity;
    public static final int BASE_FLOOR = 1;
    public static final double ELEVATING_FORCE_CONSTANT = 0.87;
    public Elevator(int currentFloor, boolean isOpen, int maxCapacity) {
        this.currentFloor = currentFloor;
        this.isOpen = isOpen;
        this.maxCapacity = maxCapacity;
    }

    // getter
    public int getCurrentFloor() { return currentFloor; }
    public boolean getIsOpen() { return this.isOpen; } // can have this keyword here (just for demonstration)
    public int getMaxCapacity() { return maxCapacity; }

    // instance/object method that use instance/object variable
    public void moveTo(int floor) {
        currentFloor = floor;
    }

    // instance/object method that use class variable
    public void moveToBaseFloor() {
        currentFloor = BASE_FLOOR;
    }

    // class method that use class variable
    // assume that the computation of force to elevate
    //  an elevator is the same among all elevators: sum of people weight * constant
    public static double computeForceToElevate(double[] peopleWeight) {
        double sum = 0;
        for (double person: peopleWeight) {
            sum += person * ELEVATING_FORCE_CONSTANT;
        }
        return sum;
    }
}

public class StaticDriver {
    public static void main(String[] args) {
        // Assume that a building has 2 elevators,
        //  one on the left and one on the right
        Elevator leftElevator = new Elevator(0, false, 10);
        Elevator rightElevator = new Elevator(0, false, 5);

        // move left elevator to floor 4, and right elevator to floor 8
        leftElevator.moveTo(4);
        rightElevator.moveTo(8);
        System.out.println("[LeftElevator] Current Floor: " + leftElevator.getCurrentFloor());
        System.out.println("[RightElevator] Current Floor: " + rightElevator.getCurrentFloor());
        System.out.println("-----------------------");

        // move left elevator back to the base floor
        leftElevator.moveToBaseFloor();
        System.out.println("[LeftElevator] Current Floor: " + leftElevator.getCurrentFloor());
        System.out.println("-----------------------");

        double forceNeeded = Elevator.computeForceToElevate(new double[]{165.3, 176.4, 90.3});
        System.out.println("Force needed to elevate the an elevator: " + forceNeeded);
    }
}
