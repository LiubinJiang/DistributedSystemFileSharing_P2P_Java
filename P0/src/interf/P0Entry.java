package interf;
import java.rmi.Remote;
import java.rmi.RemoteException;



public interface P0Entry extends Remote {
	//test connection
	public String test() throws RemoteException;
	//download
	public String obtainNode(String messageID, Integer TTL, String filename, String topology)throws RemoteException;
	//add record
	public String addRecord(String record) throws RemoteException;
	//delete record
	public String deleteRecord(String record) throws RemoteException;
	//
	//public String sendMessage(String message) throws RemoteException;
	public String getRecord(String filename) throws RemoteException;
}
