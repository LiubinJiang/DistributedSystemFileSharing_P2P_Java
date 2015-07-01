package interf;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ServerConnection extends Remote {
	public String test() throws RemoteException;
	public String obtainNode(String filename) throws RemoteException;
	public String addRecord(String record) throws RemoteException;
	public String deleteRecord(String record) throws RemoteException;
}
