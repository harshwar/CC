import java.io.*;
import java.net.*;

public class TCPChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Chat Server Started. Waiting for a client to connect...");
            
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            String receive, send;
            
            while ((receive = clientInput.readLine()) != null) {
                if (receive.equalsIgnoreCase("STOP")) {
                    System.out.println("Client has terminated the chat.");
                    break;
                }
                System.out.println("Client: " + receive);
                System.out.print("Server: ");
                send = userInput.readLine();
                out.println(send);
                if (send.equalsIgnoreCase("STOP")) {
                    System.out.println("Server is terminating the chat.");
                    break;
                }
            }
            
            socket.close();
            serverSocket.close();
            System.out.println("Connection closed.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
