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

        // Read loan information from the client
        double annualInterestRate = Double.parseDouble(in.readLine());
        int numberOfYears = Integer.parseInt(in.readLine());
        double loanAmount = Double.parseDouble(in.readLine());

        System.out.println("Received loan information from client:");
        System.out.println("Annual Interest Rate: " + annualInterestRate);
        System.out.println("Number of Years: " + numberOfYears);
        System.out.println("Loan Amount: " + loanAmount);


        // Calculate monthly and total payments
        double monthlyInterestRate = annualInterestRate / 1200;
        int numberOfPayments = numberOfYears * 12;
        double monthlyPayment =
                              (loanAmount * monthlyInterestRate)
                                           /
                        (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfPayments));

        double totalPayment = monthlyPayment * numberOfPayments;

        // Send the results back to the client
        out.println(String.format("Monthly Payment: %.2f", monthlyPayment));
        out.println(String.format("Total Payment: %.2f", totalPayment));

        System.out.println("Sent results to client:");
        System.out.println("Monthly Payment: " + String.format("%.2f", monthlyPayment));
        System.out.println("Total Payment: " + String.format("%.2f", totalPayment));

        }

}