import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        String data = "Hello, Byte Stream!";

        try (FileOutputStream fos = new FileOutputStream("ByteStreamExample.txt")) {
            byte[] byteData = data.getBytes();
            fos.write(byteData);
            System.out.println("Data written to the file.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred while writing: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream("ByteStreamExamples.txt")) {
            int byteRead;
            System.out.print("Data read from the file: ");
            while ((byteRead = fis.read()) != -1) {
                System.out.print((char) byteRead);
            }
        } catch (IOException e) {
            System.out.println("An I/O error occurred while reading: " + e.getMessage());
        }
    }
}
