package interf_3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface P3_connection extends Remote {
	void downloadFile() throws RemoteException;
	void uploadFile(String name,Integer node_id) throws RemoteException;

}
