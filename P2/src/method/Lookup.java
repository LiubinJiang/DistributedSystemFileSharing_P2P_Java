package method;

import interf.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Lookup {
	private String result="";
	private static String directory="/Users/JIANG/Documents/workspace/";
	private static String subdir="P2/messageList/2.txt";
	private static String serverP1="//localhost:8811/P1";
	private static String serverP2="//localhost:8812/P2";
	private static String serverP3="//localhost:8813/P3";
	private static String serverP4="//localhost:8814/P4";
	private static String serverP5="//localhost:8815/P5";
	private static String serverP6="//localhost:8816/P6";
	private static String serverP7="//localhost:8817/P7";
	private static String serverP8="//localhost:8818/P8";
	private static String serverP9="//localhost:8819/P9";
	private static String serverP0="//localhost:8810/P0";
	//TODO read from config file
	private Integer neighborMount=0;
	
	public boolean checkMessage(String messageID)
	{
		String filename=directory+subdir;
		File file=new File(filename);
		try {
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String lineString=null;
			while((lineString=reader.readLine())!=null){
				if(lineString.equals(messageID))
					return true;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void addMessage(String messageID){
		messageID=messageID+"\n";
		String filename=directory+subdir;
		try {
			FileWriter writer=new FileWriter(filename);
			writer.append(messageID);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String lookupFile(String messageID, Integer TTL, String filename,String topology){
		//TODO
		System.out.println(TTL);
		if(checkMessage(messageID)){
			return "";
		}else{
			if(TTL!=0){
				addMessage(messageID);
				}
		System.out.println("look up in P2");
		LocalLookup ll=new LocalLookup();
		if(ll.checkFile(filename).equals("hit")){
			result="hit 2 ";
		}
		//±¾µØlookup
		
		if(TTL>0&&topology.equals("star")){
			P0Entry p10;
			String temp=null;
			
			try {
				p10 = (P0Entry)Naming.lookup(serverP0);
				TTL=TTL-1;
				temp=p10.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
					result=result+temp;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(TTL>0&&topology.equals("mesh")){
			P1Entry p21;
			String temp=null;
			try {
				TTL=TTL-1;
				p21 = (P1Entry)Naming.lookup(serverP1);
				P3Entry p23=(P3Entry)Naming.lookup(serverP3);
				P6Entry p26=(P6Entry)Naming.lookup(serverP6);
				temp=p21.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
					result=result+temp;
				temp=p23.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
					result=result+temp;
				temp=p26.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
					result=result+temp;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		}
		
		return result;
	}
	
	public Lookup(){}

}
