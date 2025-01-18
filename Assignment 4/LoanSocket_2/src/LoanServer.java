import java.io.*;
import java.net.*;
import java.text.DecimalFormat;

public class LoanServer {
    public static void main(String[] args) throws Exception{


        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

            while (true) {
                     Socket socket = serverSocket.accept();
                     ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream()) ;


                    System.out.println("Client connected.");

                    // Read loan information from the client
                    double annualInterestRate = input.readDouble();
                    int numberOfYears = input.readInt();
                    double loanAmount = input.readDouble();

                    System.out.println("Received Loan Details:");
                    System.out.println("Annual Interest Rate: " + annualInterestRate);
                    System.out.println("Number of Years: " + numberOfYears);
                    System.out.println("Loan Amount: " + loanAmount);

                    // Calculate monthly payment and total payment
                    double monthlyInterestRate = annualInterestRate / 1200;
                    double monthlyPayment = (loanAmount * monthlyInterestRate) /
                            (1 - Math.pow(1 + monthlyInterestRate, -numberOfYears * 12));
                    double totalPayment = monthlyPayment * numberOfYears * 12;

                    // Format results
                    DecimalFormat df = new DecimalFormat("#.##");
                    monthlyPayment = Double.parseDouble(df.format(monthlyPayment));
                    totalPayment = Double.parseDouble(df.format(totalPayment));

                    // Send results back to the client
                    output.writeDouble(monthlyPayment);
                    output.writeDouble(totalPayment);
                    output.flush();

                    System.out.println("Sent monthly payment: " + monthlyPayment);
                    System.out.println("Sent total payment: " + totalPayment);

        }
    }
}
