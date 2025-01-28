import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception{
        int port = 12345; // Port number for the server
        String previousMessage = null; // Store the previous message

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);


            Socket socket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


        while (true) {
            String clientMessage = in.readLine(); // Read the message from the client
            System.out.println("Received from client: " + clientMessage);

            // Check if the message is the same as the previous one
            if (clientMessage != null && !clientMessage.equals(previousMessage)) {
                int messageLength = clientMessage.length();
                out.println("Message length: " + messageLength); // Send the length back to the client
                previousMessage = clientMessage; // Update the previous message
                continue;
            } else {
                System.out.println("Ignoring consecutive duplicate message: " + clientMessage);
                socket.close();
                return;
            }
        }
    }
}