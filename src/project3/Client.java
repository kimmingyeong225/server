package project3;

import java.io.*;
import java.net.*;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        return in.readLine();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.startConnection("127.0.0.1", 12345);
            String response = client.sendMessage("Hello Server");
            System.out.println("Response: " + response);
            client.stopConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
