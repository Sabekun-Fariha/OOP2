import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

public class Server {
    public static void main(String[] args) throws Exception{


        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream()) ;


            System.out.println("Client connected.");

            // Read loan information from the client
            double height = input.readDouble();
            double weight = input.readDouble();

            System.out.println("Height: " + height);
            System.out.println("Weight: " + weight);


            // Calculate monthly payment and total payment
            double BMI = weight / (height * height);


            // Send results back to the client
            output.writeDouble(BMI);
            output.flush();


        }
    }
}
