package test;

import implem.P0Implem;
import interf.*;

import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import method.Lookup;

//import method.UpdateFile;

public class P0Prime {
	private static String serverP0="//localhost:8810/P0";
	private static Integer p0_id=8810;
	//TODO
	private static Integer node_id=0;
	private static Integer sequenceNumber=0;
	private static String topology="mesh";
	private static Integer TTL=5;

	public static void main(String[] args) {		
		try {
			System.out.println("This is P0, topology "+topology);
			System.out.println("++++++++++++++++++++++++++++++++++++");
			
			//register as a server
			P0Implem server0 = new P0Implem();
			LocateRegistry.createRegistry(p0_id);
			Naming.rebind(serverP0, server0);
			System.out.println("P0 Initialized");
			
			//connecting to other peers
			System.out.println("connecting, press enter");
			String fiddlestick=readString("$");
			//TODO CONNET TO ALL OTHER PEERS
			
			//functions
			while(true){
			System.out.println("option:lookup, download, mylist");
			//TODO
			System.out.println("start writing");
			System.out.println("finish");
			String option=readString("$");
			if(option.equals("lookup")){
				System.out.println("filename");
				String filename=readString("$");
				String messageID=node_id.toString()+sequenceNumber.toString();
				Lookup lk=new Lookup();
				System.out.println(lk.lookupFile(messageID, TTL, filename, topology));
				sequenceNumber++;
			}
			}
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} /*catch (NotBoundException e) {
			e.printStackTrace();
		}	*/	
		}
	
	private static String readString(String prompt){
		Scanner scanner =new Scanner(System.in);
		System.out.print(prompt);
		return scanner.nextLine();
	}
}
