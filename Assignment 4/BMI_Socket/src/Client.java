import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception{


        Socket socket = new Socket("127.0.0.1", 12345);
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Connected to the server.");

        // Input loan details from the user
        System.out.print("Enter Height: ");
        double height = scanner.nextDouble();

        System.out.print("Weight: ");
        double weight = scanner.nextDouble();


        // Send loan details to the server
        output.writeDouble(height);
        output.writeDouble(weight);
        output.flush();

        // Receive the results from the server
        double BMI = input.readDouble();

        // Display the results
        System.out.println("BMI: " + BMI);



    }
}
