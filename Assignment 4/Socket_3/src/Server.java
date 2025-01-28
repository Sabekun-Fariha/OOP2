import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception{
        int port = 12345; // Port number for the server

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Client connected");

                    // Read weight and height from the client
                    double weight = Double.parseDouble(in.readLine());
                    double height = Double.parseDouble(in.readLine());

                    System.out.println("Received weight and height from client:");
                    System.out.println("Weight: " + weight + " kg");
                    System.out.println("Height: " + height + " m");

                    // Calculate BMI
                    double bmi = weight / (height * height);
                    String bmiReport = String.format("Your BMI is %.2f", bmi);

                    // Send the BMI report back to the client
                    out.println(bmiReport);

                    System.out.println("Sent BMI report to client: " + bmiReport);
    }
}