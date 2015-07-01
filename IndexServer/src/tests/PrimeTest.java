package tests;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import implem.ServerImplem;;

public class PrimeTest {
	private static String url="//localhost:8815/INDEXSERVER";
	private static Integer port_id=8815;

	public static void main(String[] args) {
		try {			
			LocateRegistry.createRegistry(port_id);
			ServerImplem server=new ServerImplem();
			Naming.rebind(url, server);
			System.out.println("Index Server Initialized!");				
		} catch (RemoteException re) {
			System.out.println("Remote Exception:"+re.toString());
			re.printStackTrace();
		} catch (MalformedURLException me) {
			System.out.println("Malformed URL"+me.toString());
			me.printStackTrace();
		}
		
		

	}

}
