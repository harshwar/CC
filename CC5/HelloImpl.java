import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/**
 * This class implements the remote interface 'Hello'.
 * It contains the actual logic for the remote method.
 * It extends UnicastRemoteObject to handle the RMI communication.
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {

    /**
     * The constructor for the implementation class.
     * It must throw a RemoteException.
     * The call to super() exports the remote object.
     */
    protected HelloImpl() throws RemoteException {
        super();
    }

    /**
     * The implementation of the remote method defined in the Hello interface.
     * @return The string to be sent back to the client.
     */
    @Override
    public String sayHello() throws RemoteException {
        return "Hello, RMI World!";
    }
}
