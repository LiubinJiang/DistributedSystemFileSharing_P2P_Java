package test;

import implem.P6Implem;
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

public class P6Prime {
	private static String serverP6="//localhost:8816/P6";
	private static Integer p6_id=8816;
	//TODO
	private static Integer node_id=6;
	private static Integer sequenceNumber=0;
	private static String topology="mesh";
	private static Integer TTL=5;

	public static void main(String[] args) {		
		try {
			System.out.println("This is P6, topology "+topology);
			System.out.println("++++++++++++++++++++++++++++++++++++");
			
			//register as a server
			P6Implem server6 = new P6Implem();
			LocateRegistry.createRegistry(p6_id);
			Naming.rebind(serverP6, server6);
			System.out.println("P6 Initialized");
			
			//functions
			while(true){
			System.out.println("option:lookup, download, mylist");
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
