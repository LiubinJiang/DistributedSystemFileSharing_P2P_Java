package interf_1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface P1_connection extends Remote {
	void downloadFile() throws RemoteException;
	void uploadFile(String name,Integer node_id) throws RemoteException;

}
