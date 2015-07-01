package tests;

import implem_3.P3_Implementation;
import interf.ServerConnection;
import interf_1.P1_connection;
import interf_2.P2_Connection;

import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import method.UpdateFile;

public class P3prime {
	private static String serverUrl="//localhost:8815/INDEXSERVER";
	private static Integer p1_id=8816;
	private static Integer p2_id=8817;
	private static Integer p3_id=8818;
	private static String serverP1="//localhost:8816/P1";
	private static String serverP2="//localhost:8817/P2";
	private static String serverP3="//localhost:8818/P3";
	private static Integer node_id=3;

	public static void main(String[] args) {
		
		try {
			//connected to index server
			System.out.println("This is P3");
			ServerConnection P3server=(ServerConnection) Naming.lookup(serverUrl);
			System.out.println("CONNECTION TO INDEX SERVER: "+P3server.test());
			System.out.println("++++++++++++++++++++++++++++++++++++");
			
			//register as a server
			P3_Implementation server3 = new P3_Implementation();
			LocateRegistry.createRegistry(p3_id);
			Naming.rebind(serverP3, server3);
			System.out.println("P3 Initialized!");
			
			//register file to Index server
			UpdateFile uf=new UpdateFile();
			P3server.addRecord(uf.initFile());
			System.out.println("Register File to Index server---Done!");
			
			//connecting to other peers
			System.out.println("connecting, press enter");
			String fiddlestick=readString("$");
			P1_connection p31=(P1_connection)Naming.lookup(serverP1);
			System.out.println("Connected to P1");	
			P2_Connection p32=(P2_Connection)Naming.lookup(serverP2);
			System.out.println("Connected to P2");
			
			while(true){
			System.out.println("option:lookup, download, mylist");
			String option=readString("$");		
				if(option.equals("lookup")){
					System.out.println("filename");
					String filename=readString("$");
					System.out.println(P3server.obtainNode(filename));
				}else{
					if(option.equals("mylist")){
						System.out.println("++++++++MY LIST+++++++++");
						System.out.println(uf.initFile());
					}else{

					/*if(option.equals("add")){
						System.out.println("filename node_id");
						String record=readString("$");
						System.out.println(P3server.addRecord(record));
					}else{
						if(option.equals("delete")){
							System.out.println("delete message with space");
							String record=readString("$");
							System.out.println(P3server.deleteRecord(record));						
						}else{*/
							if(option.equals("download")){
								System.out.println("filename");
								String filename=readString("$");
								System.out.println("node_id");
								String temp=readString("$");
								Integer node=Integer.parseInt(temp);
								System.out.println(temp);
								switch(node){
								case 1: p31.uploadFile(filename, node_id);
										System.out.println("update index list");
										P3server.addRecord(filename+" "+node_id.toString());
										break;
								case 2: p32.uploadFile(filename, node_id);
										System.out.println("update index list");
										P3server.addRecord(filename+" "+node_id.toString());
										break;
								default: break;
								}								
							}else{
								if(option.equals("exit"))
									break;
								else{
									System.out.println("ERROR!");
								}
							}
						//}
						}	
					}
				}
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}		
		}
	
	private static String readString(String prompt){
		Scanner scanner =new Scanner(System.in);
		System.out.print(prompt);
		return scanner.nextLine();
	}
}
