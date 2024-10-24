

class Person {
    private double weight;
    private int currentFloor;

    public Person(double weight, int currentFloor) {
        this.weight = weight;
        this.currentFloor = currentFloor;
    }

    public void pressUpButton(ElevatorGroup elevatorGroup) {

    }

    public void pressDownButton(ElevatorGroup elevatorGroup) {

    }

    public void pressFloorButton(Elevator elevator, int floorNum) {

    }
}

class Elevator {
    private int capacity;
    private double maxWeights;
    private boolean doorClose;
    private boolean idle;
    private int[] floorList;
    private int currentFloor;

    public Elevator(int capacity, double maxWeights) {
        this.capacity = capacity;
        this.maxWeights = maxWeights;
        doorClose = true;
        idle = true;
        floorList = new int[100];
        currentFloor = 1;
    }

    public void addFloorToQueue(int floor) {

    }

    public void moveUpOneFloor() {

    }

    public void moveDownOneFloor() {

    }
}

class ElevatorGroup {
    Elevator[] elevatorList;

    public ElevatorGroup(Elevator[] list) {
        elevatorList = list;
    }
}


public class ElevatorSystemDriver {

    ElevatorGroup elevatorGroup;
    Person[] currentFloor;

    public ElevatorSystemDriver() {
        Elevator[] list = new Elevator[]{
                new Elevator(10, 1000),
                new Elevator(11, 1200)
        };
        elevatorGroup = new ElevatorGroup(list);
        currentFloor = new Person[]{
                new Person(104.2, 3),
                new Person(78.8, 2),
                new Person(84.2, 1),
                new Person(60.3, 1),
        };
    }

}
