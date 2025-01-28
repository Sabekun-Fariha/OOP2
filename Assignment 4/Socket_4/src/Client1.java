
import java.io.*;
import java.net.*;
import java.util.*;

public class Client1 {

    public static void main(String[] args) throws Exception {

        String hostname = "localhost"; // Server hostname
        int port = 12345; // Server port

        Socket socket = new Socket(hostname, port);


        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Connected to the server. Type your messages below:");


        Random random = new Random();
        int num = random.nextInt(1000);


        out.println(num);



    }
}
