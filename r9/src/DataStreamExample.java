import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamExample {
    public static void main(String[] args) {
        // Data to write to the file
        int intData = 42;
        double doubleData = 3.14;
        boolean boolData = true;
        String stringData = "Hello, Data Stream!";

        // Writing to a file using DataOutputStream
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("dataOutput.txt"))) {
            dos.writeInt(intData);
            dos.writeDouble(doubleData);
            dos.writeBoolean(boolData);
            dos.writeUTF(stringData);  // Writes a string in UTF format
            System.out.println("Data written to the file.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred while writing: " + e.getMessage());
        }

        // Reading from a file using DataInputStream
        try (DataInputStream dis = new DataInputStream(new FileInputStream("dataOutput.txt"))) {
            int readInt = dis.readInt();
            double readDouble = dis.readDouble();
            boolean readBoolean = dis.readBoolean();
            String readString = dis.readUTF();  // Reads the string in UTF format

            // Output the read data
            System.out.println("Data read from the file:");
            System.out.println("Integer: " + readInt);
            System.out.println("Double: " + readDouble);
            System.out.println("Boolean: " + readBoolean);
            System.out.println("String: " + readString);
        } catch (IOException e) {
            System.out.println("An I/O error occurred while reading: " + e.getMessage());
        }
    }
}
