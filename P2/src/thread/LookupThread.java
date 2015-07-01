package thread;

import interf.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LookupThread extends Thread {
	private Integer thread_id;
	private static String serverUrl="//localhost:8815/INDEXSERVER";
	
	//connect to index server
	
		public LookupThread(Integer thread_id){
			super();
			this.thread_id=thread_id;			
			start();		
		}
		public void run(){
			
			/*try {
				System.out.println("This is thread "+thread_id);
				ServerConnection LThread = (ServerConnection) Naming.lookup(serverUrl);
				System.out.println("thread "+thread_id+" CONNECTION TO INDEX SERVER: "+LThread.test());
				System.out.println("thread "+thread_id+" result node "+LThread.obtainNode("author.txt"));
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (RemoteException e) {
				
				e.printStackTrace();
			} catch (NotBoundException e) {
			
				e.printStackTrace();
			}*/
			
			
		}

}
