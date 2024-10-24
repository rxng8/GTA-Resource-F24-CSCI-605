import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedCharacterExample {

    public static void main(String[] args) {
        try {
            // Create the piped reader and writer
            PipedWriter pipedWriter = new PipedWriter();
            PipedReader pipedReader = new PipedReader(pipedWriter);

            // Thread for writing data
            Thread writerThread = new Thread(() -> {
                try {
                    String data = "Hello from the writer thread!";
                    pipedWriter.write(data);
                    pipedWriter.close(); // Close the writer after writing
                } catch (IOException e) {
                    System.out.println("Writer Thread: An error occurred - " + e.getMessage());
                }
            });

            // Thread for reading data
            Thread readerThread = new Thread(() -> {
                try {
                    int charRead;
                    System.out.print("Reader Thread received: ");
                    while ((charRead = pipedReader.read()) != -1) {
                        System.out.print((char) charRead); // Print the character being read
                    }
                    System.out.println(); // New line after reading is done
                    pipedReader.close(); // Close the reader after reading
                } catch (IOException e) {
                    System.out.println("Reader Thread: An error occurred - " + e.getMessage());
                }
            });

            // Start both threads
            writerThread.start();
            readerThread.start();

            // Join the threads to ensure they complete
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
