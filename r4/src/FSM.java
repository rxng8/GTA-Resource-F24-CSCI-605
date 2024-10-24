// pattern: is: ^a(b+c)$
public class FSM {
    static enum State {
        START,      // Initial state
        A_SEEN,     // After 'a' is seen
        B_SEEN,     // After one or more 'b' is seen
        C_SEEN,     // After 'c' is seen
        REJECT      // Invalid state
    }

    static State currentState;

    static void processChar(char ch) {
        switch (currentState) {
            case START:
                if (ch == 'a') {
                    currentState = State.A_SEEN;
                } else {
                    currentState = State.REJECT;
                }
                break;
            case A_SEEN:
                if (ch == 'b') {
                    currentState = State.B_SEEN;
                } else {
                    currentState = State.REJECT;
                }
                break;
            case B_SEEN:
                if (ch == 'b') {
                    currentState = State.B_SEEN;  // Stay in B_SEEN if more 'b's are encountered
                } else if (ch == 'c') {
                    currentState = State.C_SEEN;
                } else {
                    currentState = State.REJECT;
                }
                break;
            case C_SEEN:
                currentState = State.REJECT;
                break;
            case REJECT:
                break;
        }
    }

    static boolean isAccepted(String input) {
        currentState = State.START;

        for (char ch : input.toCharArray()) {
            processChar(ch);
        }
        return currentState == State.C_SEEN;
    }

    public static void main(String[] args) {

        String[] testInputs = {"abc", "abbbc", "ac", "abb", "a", "b", "bc", "bbbc"};

        for (String input : testInputs) {
            System.out.println("Input: \"" + input + "\" is " + (isAccepted(input) ? "accepted" : "rejected"));
        }
    }
}