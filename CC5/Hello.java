import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This is the remote interface.
 * It defines the method(s) that can be called remotely by a client.
 * Any class that wants to be a remote object must implement this interface.
 * It must extend the java.rmi.Remote interface.
 */
public interface Hello extends Remote {
    /**
     * This is the remote method that the client will call.
     * It must throw a RemoteException.
     * @return A greeting string from the server.
     * @throws RemoteException if a communication-related error occurs.
     */
    String sayHello() throws RemoteException;
}
