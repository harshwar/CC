import java.io.*;
import java.net.*;

public class udpClientEO {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(); // OS will assign a port
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a number: ");
            String numStr = br.readLine();
            
            byte[] b = numStr.getBytes();
            InetAddress serverAddress = InetAddress.getLocalHost();
            int serverPort = 2000;
            
            DatagramPacket dp = new DatagramPacket(b, b.length, serverAddress, serverPort);
            ds.send(dp);
            
            byte[] b1 = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
            ds.receive(dp1);
            
            String result = new String(dp1.getData(), 0, dp1.getLength());
            System.out.println("Server says: " + result);
            
            ds.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


