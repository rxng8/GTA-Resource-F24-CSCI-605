import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCharacterExample {
    public static void main(String[] args) {
        String data = "Hello, Buffered Character Stream!";

        // Writing to a file using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BufferedCharacterExample.txt"))) {
            writer.write(data);
            System.out.println("Data written to the file.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred while writing: " + e.getMessage());
        }

        // Reading from a file using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader("BufferedCharacterExample.txt"))) {
            String line;
            System.out.print("Data read from the file: ");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Read and print each line
            }
        } catch (IOException e) {
            System.out.println("An I/O error occurred while reading: " + e.getMessage());
        }
    }
}
