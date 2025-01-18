package server;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception{
        ServerSocket serversocket = new ServerSocket(12345);
        System.out.println("Server started");

        Socket socket = serversocket.accept(); // Client Acceptance

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String message = dis.readUTF();
        System.out.println("Message from client: " + message);
        int length = message.length();
        dos.write(length);
    }
}
