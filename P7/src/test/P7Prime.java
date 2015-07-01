package test;

import implem.P7Implem;
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
import method.Modified;
import method.UpdateList;

//import method.UpdateFile;

public class P7Prime {
	private static String serverP7="//localhost:8817/P7";
	private static Integer p7_id=8817;
private static String serverP1="//localhost:8811/P1";
	
	private static String serverP0="//localhost:8810/P0";
	//TODO
	private static Integer node_id=7;
	private static Integer sequenceNumber=0;
	private static String topology="star";
	private static Integer TTL=5;

	public static void main(String[] args) {		
		try {
			System.out.println("This is P7, topology "+topology);
			System.out.println("++++++++++++++++++++++++++++++++++++");
			
			//register as a server
			P7Implem server7 = new P7Implem();
			LocateRegistry.createRegistry(p7_id);
			Naming.rebind(serverP7, server7);
			System.out.println("P7 Initialized");
			
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
			//TODO download 
			if(option.equals("download")){
				System.out.println("filename");
				String filename=readString("$");
				System.out.println("serverID");
				String serverID=readString("$");
				System.out.println("starts downloading");
				UpdateList ul=new UpdateList();
				//versionid=remote download
				//need serverid, versionid, filename
				ul.addtoList(serverID, filename, "0");
				
				//update push list
			}
			//TODO modified
			if(option.equals("modified")){
				System.out.println("filename");
				String filename=readString("$");
				Modified m=new Modified();
				m.updateVersion(filename);
				System.out.println(filename+" version changed:"+m.getVersionID(filename));
		
				//TODO remote push changes 调用别的节点的remote方法改pushlist
				P1Entry p01;
				try {
					p01 = (P1Entry)Naming.lookup(serverP1);
					p01.pushChange(filename);
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
