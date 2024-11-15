// MultiThreadedHTTPServer.java
import java.io.*;
import java.net.*;

// Example: curl "http://localhost:8080?name=John"

public class MultiThreadedHTTPServer {
    public static void main(String[] args) {
        int port = 8080; // HTTP port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Infinite loop to accept multiple client connections
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread for each client
                new ClientHandler2(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}

// ClientHandler2 class to handle individual client connections
class ClientHandler2 extends Thread {
    private Socket socket;

    public ClientHandler2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true)
        ) {
            // Read the first line of the HTTP request
            String requestLine = reader.readLine();
            if (requestLine == null || requestLine.isEmpty()) {
                return;
            }

            System.out.println("Request: " + requestLine);

            // Parse the name parameter from the GET request
            String name = parseNameFromRequest(requestLine);
            String responseMessage;

            // Check if the name is provided
            if (name != null && !name.isEmpty()) {
                responseMessage = "Hi, " + name + "!";
            } else {
                responseMessage = "Hi, there!";
            }

            // Send HTTP response headers
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type: text/plain; charset=UTF-8");
            writer.println("Content-Length: " + responseMessage.length());
            writer.println("Connection: close");
            writer.println();

            // Send the single string response
            writer.println(responseMessage);

            // Close the connection
            socket.close();
            System.out.println("Client connection closed");
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

    // Method to parse the 'name' parameter from the GET request line
    private String parseNameFromRequest(String requestLine) {
        try {
            // Example request line: "GET /?name=John HTTP/1.1"
            if (requestLine.startsWith("GET")) {
                // Extract the part between "GET /" and "HTTP/1.1"
                String[] parts = requestLine.split(" ");
                if (parts.length > 1) {
                    String query = parts[1]; // This is "/?name=John"

                    // Check if there's a query string starting with '?'
                    if (query.contains("?")) {
                        String[] queryParams = query.split("\\?");
                        if (queryParams.length > 1) {
                            // Parse the parameters, e.g., "name=John"
                            String[] params = queryParams[1].split("&");
                            for (String param : params) {
                                String[] keyValue = param.split("=");
                                if (keyValue.length == 2 && keyValue[0].equals("name")) {
                                    return URLDecoder.decode(keyValue[1], "UTF-8"); // Return the value of 'name'
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error parsing name from request: " + e.getMessage());
        }
        return null; // Return null if 'name' parameter is not found
    }
}
