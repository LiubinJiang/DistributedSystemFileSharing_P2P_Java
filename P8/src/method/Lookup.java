package method;

import interf.*;

import java.io.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;



public class Lookup {
	private String result="";
	private static String directory="/Users/JIANG/Documents/workspace/";
	private static String subdir="P8/messageList/8.txt";
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
	//TODO read from config file neighborMount=0;
	
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
		if(checkMessage(messageID)){
			return "";
		}else{
			if(TTL!=0){
				addMessage(messageID);
				}
			System.out.println("look up in P8");
			LocalLookup ll=new LocalLookup();
			if(ll.checkFile(filename).equals("hit")){
				result="hit 8 ";
		}
		//±¾µØlookup
		
		if(TTL>0&&topology.equals("star")){
			//TODO CONNET TO neighbor PEERS
			String temp=null;
			P0Entry p80;
			try {
				p80 = (P0Entry)Naming.lookup(serverP0);
				TTL=TTL-1;
				temp=p80.obtainNode(messageID,TTL,filename,topology);
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
			P9Entry p89;
			String temp=null;
			try {
				TTL=TTL-1;
				p89 = (P9Entry)Naming.lookup(serverP9);
				P4Entry p84=(P4Entry)Naming.lookup(serverP4);
				temp=p89.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
					result=result+temp;
				temp=p84.obtainNode(messageID,TTL,filename,topology);
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
