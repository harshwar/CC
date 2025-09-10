import java.io.*;
import java.net.*;

public class TCPChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Connected to the chat server.");
            System.out.println("To stop chatting, just type 'STOP'.");
            
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            String msg, reply;
            
            while (true) {
                System.out.print("Client: ");
                msg = userInput.readLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("STOP")) {
                    System.out.println("You have terminated the chat.");
                    break;
                }
                
                reply = serverInput.readLine();
                if (reply == null || reply.equalsIgnoreCase("STOP")) {
                    System.out.println("Server has terminated the chat.");
                    break;
                }
                System.out.println("Server: " + reply);
            }
            
            socket.close();
            System.out.println("Connection closed.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
