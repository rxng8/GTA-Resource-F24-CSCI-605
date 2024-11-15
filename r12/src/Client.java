// Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost"; // Change to server IP if running on a different machine
        int port = 8080;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to the server!");

            // Input and output streams for communication
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Send a message to the server
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String message;
            System.out.println("Enter your message (type 'exit' to quit):");

            while (true) {
                System.out.print("> ");
                message = consoleReader.readLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(message); // Send message to server
                String response = reader.readLine(); // Read response from server
                System.out.println("Server response: " + response);
            }
        } catch (UnknownHostException e) {
            System.err.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
