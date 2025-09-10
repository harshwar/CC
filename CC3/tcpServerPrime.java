import java.net.*;
import java.io.*;

class tcpServerPrime {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(8001);
            System.out.println("Server Started.............");
            
            // Server runs indefinitely
            while (true) {
                Socket s = ss.accept();
                System.out.println("Client connected.");
                
                DataInputStream in = new DataInputStream(s.getInputStream());
                int x = in.readInt();
                
                DataOutputStream otc = new DataOutputStream(s.getOutputStream());
                
                boolean isPrime = true;
                if (x <= 1) {
                    isPrime = false;
                } else {
                    for (int i = 2; i <= Math.sqrt(x); i++) {
                        if (x % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
                
                if (isPrime) {
                    otc.writeUTF(x + " is a Prime Number.");
                } else {
                    otc.writeUTF(x + " is not a Prime Number.");
                }
                
                s.close();
                System.out.println("Client disconnected.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
