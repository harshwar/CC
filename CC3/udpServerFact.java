import java.io.*;
import java.net.*;

public class udpServerFact {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(2000);
            System.out.println("UDP Factorial Server Started on port 2000.");
            
            byte[] b1 = new byte[1024];
            DatagramPacket dp = new DatagramPacket(b1, b1.length);
            ds.receive(dp);
            
            String str = new String(dp.getData(), 0, dp.getLength()).trim();
            System.out.println("Received number: " + str);
            
            int num = Integer.parseInt(str);
            long fact = 1;
            
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
            
            String result = "Factorial of " + num + " is " + fact;
            byte[] b2 = result.getBytes();
            
            InetAddress clientAddress = dp.getAddress();
            int clientPort = dp.getPort();
            
            DatagramPacket dp1 = new DatagramPacket(b2, b2.length, clientAddress, clientPort);
            ds.send(dp1);
            
            System.out.println("Sent result to client.");
            ds.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
