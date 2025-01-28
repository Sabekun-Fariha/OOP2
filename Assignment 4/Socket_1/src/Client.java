import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        String hostname = "localhost"; // Server hostname
        int port = 12345; // Server port

        Socket socket = new Socket(hostname, port);


        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Connected to the server. Type your messages below:");

        while (true) {

            String userInput = consoleInput.readLine(); // Read user input
            out.println(userInput); // Send the message to the server

            String serverResponse = in.readLine(); // Read the server's response
            if (serverResponse != null) {
                System.out.println("Server response: " + serverResponse);
                continue;
            } else {
                System.out.println("Server did not respond (possibly due to consecutive duplicate message).");
                socket.close();
                return;
            }
        }

    }
}