
import java.io.*;
import java.net.*;

public class MultiThreadedServer {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Infinite loop to accept multiple client connections
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}

// ClientHandler class handles individual client connection in a separate thread
class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true)
        ) {
            String clientMessage;

            // Communication loop
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);
                writer.println("Server response: " + clientMessage.toUpperCase());

                // Exit condition for client
                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket closing error: " + e.getMessage());
            }
        }
    }
}
