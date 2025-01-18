package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class Client {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 12345);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        dos.writeUTF("Sabekun Nahar Fariha");
        int serverMessage = dis.read();
        System.out.println("Message from server: " + serverMessage);

    }
}
