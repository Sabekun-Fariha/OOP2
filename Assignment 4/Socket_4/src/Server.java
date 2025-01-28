import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {

        int port = 12345; // Port number for the server
        String previousMessage = null; // Store the previous message

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);


        Socket socketforClient1 = serverSocket.accept();
        Socket socketforClient2 = serverSocket.accept();

        BufferedReader in1 = new BufferedReader(new InputStreamReader(socketforClient1.getInputStream()));
        BufferedReader in2 = new BufferedReader(new InputStreamReader(socketforClient2.getInputStream()));

        PrintWriter out1 = new PrintWriter(socketforClient1.getOutputStream(), true);
        PrintWriter out2 = new PrintWriter(socketforClient2.getOutputStream(), true);


        Integer num = Integer.parseInt(in1.readLine());
        System.out.println("Number is: "+ num);
        String oddoreven = null;

        if(num % 2 == 0){
            oddoreven = "even";
        }else{
            oddoreven = "odd";
        }


        out2.println(oddoreven);
        out2.println(num);




    }

}
