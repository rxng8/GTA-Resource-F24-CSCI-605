

public class FinallyDriver {

    public static void NoFinallyExample() {
        for (int i = 0; i < 10; i++) {
            try {
                if (i >= 5) throw new Exception("An exception occurred");
                System.out.println("In try block " + i);
            } catch (Exception e) {
                System.out.println("In catch block: " + e.getMessage());
                break;
            }
        }
        System.out.println("Print number end!");
    }

    public static void FinallyExample() {
        for (int i = 0; i < 10; i++) {
            try {
                if (i >= 5) throw new Exception("An exception occurred");
                System.out.println("In try block " + i);
            } catch (Exception e) {
                System.out.println("In catch block: " + e.getMessage());
                return;
            } finally {
                System.out.println("Finally block: This is guaranteed to be executed. Block " + i);
            }
        }
        System.out.println("Print number end!");
    }

    public static void main(String[] args) {

        //NoFinallyExample();

        FinallyExample();

    }

}
