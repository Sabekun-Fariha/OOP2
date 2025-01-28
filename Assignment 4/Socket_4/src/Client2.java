import java.io.*;
import java.net.*;

public class Client2 {

    public static void main(String[] args) throws Exception{

        String hostname = "localhost"; // Server hostname
        int port = 12345; // Server port

        Socket socket = new Socket(hostname, port);


        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Connected to the server. Type your messages below:");

        String oddoreven = in.readLine();
        Integer num = Integer.parseInt(in.readLine());

        if(oddoreven.equals("odd")){
            num = num + 2;
            System.out.println("Next odd: " + num);
        }
        else{
            num = num + 2;
            System.out.println("Next even: " + num);
        }


    }
}
