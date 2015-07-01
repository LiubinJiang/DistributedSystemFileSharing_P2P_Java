package test;

import implem.P1Implem;
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

public class P1Prime {
	private static String serverP1="//localhost:8811/P1";
	private static Integer p1_id=8811;
	//TODO
	private static Integer node_id=1;
	private static Integer sequenceNumber=0;
	private static String topology="star";
	private static Integer TTL=2;

	public static void main(String[] args) {		
		try {
			System.out.println("This is P1, topology "+topology);
			System.out.println("+++++++++++++++++++push+++++++++++++");
			
			//register as a server
			P1Implem server1 = new P1Implem();
			LocateRegistry.createRegistry(p1_id);
			Naming.rebind(serverP1, server1);
			System.out.println("P1 Initialized");
			
			//functions
			while(true){
			System.out.println("option:lookup, download,modified");
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
