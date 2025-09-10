import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * This is the RMI client application.
 * It looks up the remote object from the RMI registry and invokes
 * its remote method.
 */
public class Client {
    public static void main(String[] args) {
        try {
            // Get the registry from the server's host and port
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object by its binding name ("HelloService")
            // This returns a stub (a proxy for the remote object)
            Hello stub = (Hello) registry.lookup("HelloService");

            // Invoke the remote method
            String response = stub.sayHello();

            // Print the response received from the server
            System.out.println("Response: " + response);

        } catch (Exception e) {
            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
