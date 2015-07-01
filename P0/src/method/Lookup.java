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
	private static String subdir="P0/messageList/0.txt";
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
		
			System.out.println("LOOKUP.lookup");
			if(TTL!=0){
				addMessage(messageID);
				}
			System.out.println("look up in P0");
			LocalLookup ll=new LocalLookup();
			if(ll.checkFile(filename).equals("hit")){
				result="hit 0 ";
			}
			//TODO
			System.out.println("hit 0");
			//TODO modified
		
			P1Entry p01;
			String temp=null;
			try {
				p01 = (P1Entry)Naming.lookup(serverP1);
				temp=p01.obtainNode(messageID,TTL,filename,topology);
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
		return result;
		
		/*if(TTL>0&&topology.equals("star")){
			P1Entry p01;
			String temp=null;
			try {
				p01 = (P1Entry)Naming.lookup(serverP1);
				P2Entry p02=(P2Entry)Naming.lookup(serverP2);
				P3Entry p03=(P3Entry)Naming.lookup(serverP3);
				P4Entry p04=(P4Entry)Naming.lookup(serverP4);
				P5Entry p05=(P5Entry)Naming.lookup(serverP5);
				P6Entry p06=(P6Entry)Naming.lookup(serverP6);
				P7Entry p07=(P7Entry)Naming.lookup(serverP7);
				P8Entry p08=(P8Entry)Naming.lookup(serverP8);
				P9Entry p09=(P9Entry)Naming.lookup(serverP9);
				TTL=TTL-1;
				temp=p01.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
				result=result+temp;
				temp=p02.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
				result=result+temp;
				temp=p03.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
				result=result+temp;
				temp=p04.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
				result=result+temp;
				temp=p05.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
				result=result+temp;
				temp=p06.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
				result=result+temp;
				temp=p07.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
				result=result+temp;
				temp=p08.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
				result=result+temp;
				temp=p09.obtainNode(messageID,TTL,filename,topology);
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
			P1Entry p01;
			String temp=null;
			try {
				TTL=TTL-1;
				p01 = (P1Entry)Naming.lookup(serverP1);
				P4Entry p04=(P4Entry)Naming.lookup(serverP4);
				temp=p01.obtainNode(messageID,TTL,filename,topology);
				if(temp!=null)
				result=result+temp;
				temp=p04.obtainNode(messageID,TTL,filename,topology);
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
		//TODO
		System.out.println(result);
		}*/
	}
	
	public Lookup(){}

}
