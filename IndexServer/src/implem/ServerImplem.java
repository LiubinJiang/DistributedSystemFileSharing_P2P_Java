package implem;
import interf.ServerConnection;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import serverMethod.ClientMethod;

//TODO
//import entity.ClientMethod;
//import entity.ClientMethod;
//import entity.IndexFile;

public class ServerImplem extends UnicastRemoteObject implements ServerConnection {
	public ServerImplem() throws RemoteException{
		super();
	}

	public String test() throws RemoteException {
			return "succeed!";
	}

	@Override
	public String obtainNode(String filename) throws RemoteException {
		ClientMethod cm=new ClientMethod();
		return cm.Clientlookup(filename);
	}

	@Override
	public String addRecord(String record) throws RemoteException {
		ClientMethod cm=new ClientMethod();
		return cm.Clientadd(record);
	}

	@Override
	public String deleteRecord(String record) throws RemoteException {
		ClientMethod cm=new ClientMethod();
		return cm.Clientdelete(record);
	}
	

}
