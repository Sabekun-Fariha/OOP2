import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception{
        String hostname = "localhost"; // Server hostname
        int port = 12345; // Server port

        Socket socket = new Socket(hostname, port);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Connected to the server.");

        // Get loan information from the user
            System.out.print("Enter annual interest rate (e.g., 7.25): ");
            String annualInterestRate = consoleInput.readLine();
            System.out.print("Enter number of years as an integer: ");
            String numberOfYears = consoleInput.readLine();
            System.out.print("Enter loan amount (e.g., 120000.95): ");
            String loanAmount = consoleInput.readLine();


            // Send loan information to the server
            out.println(annualInterestRate);
            out.println(numberOfYears);
            out.println(loanAmount);

            // Receive and display the results from the server
            String monthlyPayment = in.readLine();
            String totalPayment = in.readLine();
            System.out.println("Server response:");
            System.out.println(monthlyPayment);
            System.out.println(totalPayment);


    }
}