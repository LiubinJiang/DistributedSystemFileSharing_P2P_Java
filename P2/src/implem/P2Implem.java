package implem;
import interf.P2Entry;
import interf.QueryInfo;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import method.Lookup;



//import serverMethod.ClientMethod;

//TODO
//import entity.ClientMethod;
//import entity.ClientMethod;
//import entity.IndexFile;

public class P2Implem extends UnicastRemoteObject implements P2Entry {
	public P2Implem() throws RemoteException{
		super();
	}

	public String test() throws RemoteException {
			return "succeed!";
	}


	@Override
	public String addRecord(String record) throws RemoteException {
		//ClientMethod cm=new ClientMethod();
		//return cm.Clientadd(record);
		//TODO
		return "undone";
	}

	@Override
	public String deleteRecord(String record) throws RemoteException {
		//ClientMethod cm=new ClientMethod();
		//return cm.Clientdelete(record);
		//TODO
		return "undone";
	}


	public String obtainNode(String messageID, Integer TTL, String filename, String topology)
			throws RemoteException {
		String result=null;
		Lookup lk=new Lookup();	
		result=lk.lookupFile(messageID, TTL, filename,topology);
		return result;
	}
	

}
