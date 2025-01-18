import java.io.*;
import java.net.*;
import java.util.Scanner;

public class LoanClient {
    public static void main(String[] args) throws Exception{


             Socket socket = new Socket("127.0.0.1", 12345);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in);

            System.out.println("Connected to the server.");

            // Input loan details from the user
            System.out.print("Enter annual interest rate: ");
            double annualInterestRate = scanner.nextDouble();

            System.out.print("Enter number of years: ");
            int numberOfYears = scanner.nextInt();

            System.out.print("Enter loan amount: ");
            double loanAmount = scanner.nextDouble();

            // Send loan details to the server
            output.writeDouble(annualInterestRate);
            output.writeInt(numberOfYears);
            output.writeDouble(loanAmount);
            output.flush();

            // Receive the results from the server
            double monthlyPayment = input.readDouble();
            double totalPayment = input.readDouble();

            // Display the results
            System.out.println("Monthly Payment: " + monthlyPayment);
            System.out.println("Total Payment: " + totalPayment);


    }
}
