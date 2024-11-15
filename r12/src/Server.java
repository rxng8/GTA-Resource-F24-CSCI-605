// Server.java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Port number
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // the socket that we listening on is localhost:12345
            //  or 129.0.0.1:12345
            System.out.println("Server is listening on port " + port);

            // Wait for client connection
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected!");

                // Input and output streams for communication
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String message;
                // Read and respond to client messages
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    writer.println("Return message from the server: " + message); // Echo back the message
                }

            } catch (IOException e) {
                System.err.println("Client connection error: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
