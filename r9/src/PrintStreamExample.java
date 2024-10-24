import java.io.*;

public class PrintStreamExample {
    public static void main(String[] args) {
        String filePath = "PrintStreamExample.txt";
        String errorFilePath = "PrintStreamExample_ERROR.txt";

        // Writing to the file using PrintStream
        try (PrintStream ps = new PrintStream(new FileOutputStream(filePath));
             PrintStream errorPs = new PrintStream(new FileOutputStream(errorFilePath))) {

            // Set the standard error stream to errorPs (redirecting errors to error_log.txt)
            System.setErr(errorPs);

            // Writing normal output
            ps.println("This is a normal message.");
            ps.println("Another line of normal output.");

            // Simulating an error by forcing an exception (divide by zero)
            try {
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.err.println("Error occurred: Division by zero.");
            }

            System.out.println("Data written to file successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
