public class ElevatorControlSystem {

    // [Idle] --(press button)--> [Moving] --> [Door Open] --> [Idle]
    // [Moving] --> (press emergency button) --> [Emergency]

    private enum State {
        IDLE,
        MOVING_UP,
        MOVING_DOWN,
        DOOR_OPEN,
        EMERGENCY
    }

    private State currentState;

    private int currentFloor;
    private int targetFloor;
    private boolean isEmergency;

    public ElevatorControlSystem() {
        this.currentState = State.IDLE;
        this.currentFloor = 1;
        this.isEmergency = false;
        this.targetFloor = 1;
    }

    public void request(int requestedFloor, boolean isEmergency) {
        // Transition the state
        this.targetFloor = requestedFloor;
        if (isEmergency) {
            currentState = State.EMERGENCY;
            System.out.println("Elevator is in emergency mode!");
        } else if (targetFloor > currentFloor) {
            currentState = State.MOVING_UP;
            System.out.println("Elevator moving up from floor " + currentFloor + " to floor " + targetFloor);
        } else if (targetFloor < currentFloor) {
            currentState = State.MOVING_DOWN;
            System.out.println("Elevator moving down from floor " + currentFloor + " to floor " + targetFloor);
        } else {
            currentState = State.DOOR_OPEN;
            System.out.println("Elevator already at floor " + currentFloor + ", opening doors.");
        }
        process();
    }

    private void process() {
        switch (currentState) {
            case EMERGENCY:
                isEmergency = true;
                targetFloor = currentFloor;
                System.out.println("Emergency mode! Freeze the elevator");
                break;

            case MOVING_UP:
                if (currentFloor < targetFloor) {
                    currentFloor++;
                    System.out.println("Passing floor " + currentFloor);
                } else if (currentFloor == targetFloor) {
                    currentState = State.DOOR_OPEN; // Change the state here
                }
                process(); // Actual logic for opening the door once we reach the target
                break;

            case MOVING_DOWN:
                if (currentFloor > targetFloor) {
                    currentFloor--;
                    System.out.println("Passing floor " + currentFloor);
                } else if (currentFloor == targetFloor) {
                    currentState = State.DOOR_OPEN; // Change the state here
                }
                process(); // Actual logic
                break;

            case DOOR_OPEN:
                System.out.println("Doors opening at floor " + currentFloor);
                System.out.println("Elevator has arrived at floor " + currentFloor);
                currentState = State.IDLE;
                break;

            case IDLE:
                System.out.println("Elevator is idle.");
                break;
        }
    }

    public static void main(String[] args) {
        ElevatorControlSystem elevator = new ElevatorControlSystem();

        // Example scenario: requests for different floors
        elevator.request(5, false);
        elevator.request(3, false);
        elevator.request(10, true);

    }
}
