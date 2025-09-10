import java.io.*;
import java.net.*;

public class udpServerEO {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(2000); // Server port
            System.out.println("UDP Even/Odd Server Started on port 2000.");
            
            byte[] b = new byte[1024];
            DatagramPacket dp = new DatagramPacket(b, b.length);
            ds.receive(dp);
            
            String str = new String(dp.getData(), 0, dp.getLength()).trim();
            System.out.println("Received from client: " + str);
            
            int num = Integer.parseInt(str);
            String result = (num % 2 == 0) ? "Number is Even" : "Number is Odd";
            
            byte[] sendData = result.getBytes();
            
            // Get client address and port from the received packet
            InetAddress clientAddress = dp.getAddress();
            int clientPort = dp.getPort();
            
            DatagramPacket dp1 = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            ds.send(dp1);
            
            System.out.println("Sent response to client.");
            ds.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


