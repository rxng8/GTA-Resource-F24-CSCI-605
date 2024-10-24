import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterExample {
    public static void main(String[] args) {
        String data = "Hello, Character Stream!";

        // Writing to a file using FileWriter (character stream)
        try (FileWriter writer = new FileWriter("CharacterExample.txt")) {
            writer.write(data);
            System.out.println("Data written to the file.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred while writing: " + e.getMessage());
        }

        // Reading from a file using FileReader (character stream)
        try (FileReader reader = new FileReader("CharacterExample.txt")) {
            int charRead;
            System.out.print("Data read from the file: ");
            while ((charRead = reader.read()) != -1) {
                System.out.print((char) charRead);  // Read and print each character
            }
        } catch (IOException e) {
            System.out.println("An I/O error occurred while reading: " + e.getMessage());
        }
    }
}
