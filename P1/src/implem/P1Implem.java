package implem;
import interf.P1Entry;
import interf.QueryInfo;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import method.Lookup;
import method.PushMethod;
//import serverMethod.ClientMethod;

//TODO
//import entity.ClientMethod;
//import entity.ClientMethod;
//import entity.IndexFile;

public class P1Implem extends UnicastRemoteObject implements P1Entry {
	public P1Implem() throws RemoteException{
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

	@Override
	public String obtainNode(String messageID, Integer TTL, String filename, String topology)
			throws RemoteException {
		String result=null;
		Lookup lk=new Lookup();	
		result=lk.lookupFile(messageID, TTL, filename,topology);
		return result;
	}

	@Override
	public String pushChange(String filename)
			throws RemoteException {
		PushMethod pm=new PushMethod();
		pm.updatePushList(filename);
		// TODO Auto-generated method stub
		return null;
	}
	

}
