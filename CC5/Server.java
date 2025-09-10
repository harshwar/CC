import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * This is the RMI server application.
 * It creates an instance of the remote object, registers it with the
 * RMI registry, and waits for clients to invoke methods on it.
 */
public class Server {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote object implementation
            HelloImpl obj = new HelloImpl();

            // Create an RMI registry on a specific port (e.g., 1099)
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object's instance to a name in the registry
            registry.rebind("HelloService", obj);

            System.out.println("Server ready...");

        } catch (Exception e) {
            System.err.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
