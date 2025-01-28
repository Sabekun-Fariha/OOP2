import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        String hostname = "localhost"; // Server hostname 127.0.0.1
        int port = 12345; // Server port

        Socket socket = new Socket(hostname, port);


        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Connected to the server.");

            // Get weight and height from the user
            System.out.print("Enter your weight in kilograms: ");
            String weight = consoleInput.readLine();
            System.out.print("Enter your height in meters: ");
            String height = consoleInput.readLine();

            // Send weight and height to the server
            out.println(weight);
            out.println(height);

            // Receive and display the BMI report from the server
            String bmiReport = in.readLine();
            System.out.println("Server response: " + bmiReport);
    }
}