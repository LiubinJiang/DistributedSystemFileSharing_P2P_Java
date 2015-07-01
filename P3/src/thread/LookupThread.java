package thread;

import interf.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import method.Lookup;

public class LookupThread extends Thread {
	private Integer thread_id;
	private Integer messageID;
	//private static String serverUrl="//localhost:8815/INDEXSERVER";
	
	//connect to index server
	
		public LookupThread(Integer thread_id,Integer messageID){
			super();
			this.thread_id=thread_id;	
			this.messageID=messageID;
			
			start();		
		}
		public void run(){
			
				System.out.println("This is thread "+thread_id);
				Lookup lk=new Lookup();
				String[] result=new String[10];
				for(Integer i=0;i<10;i++){
					result[i]=lk.lookupFile(messageID+i.toString(), 5,i.toString()+"k.txt", "star");
					System.out.println("thread "+thread_id+" "+result[i]);
				}
				
			
		}

}
