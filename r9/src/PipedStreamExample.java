import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamExample {

    public static void main(String[] args) {
        try {
            // Create the piped input and output streams
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

            // Thread for writing data
            Thread writerThread = new Thread(() -> {
                try {
                    String data = "Hello from the writer thread!";
                    pipedOutputStream.write(data.getBytes());
                    pipedOutputStream.close(); // Close the stream after writing
                } catch (IOException e) {
                    System.out.println("Writer Thread: An error occurred - " + e.getMessage());
                }
            });

            // Thread for reading data
            Thread readerThread = new Thread(() -> {
                try {
                    int byteRead;
                    System.out.print("Reader Thread received: ");
                    while ((byteRead = pipedInputStream.read()) != -1) {
                        System.out.print((char) byteRead);
                    }
                    System.out.println(); // New line after reading is done
                    pipedInputStream.close(); // Close the stream after reading
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
