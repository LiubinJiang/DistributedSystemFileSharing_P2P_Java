package interf_2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface P2_Connection extends Remote {
	void downloadFile() throws RemoteException;
	void uploadFile(String name,Integer node_id) throws RemoteException;

}
