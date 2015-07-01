package thread;

import interf.ServerConnection;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import method.UpdateFile;

public class CheckThread extends Thread {
	private String filelist="";
	private static String serverUrl="//localhost:8815/INDEXSERVER";
	
	public CheckThread(String filelist){
		super();
		this.filelist=filelist;
		start();
	}
	
	public void run(){
		
		UpdateFile uf=new UpdateFile();
		try {
			Thread.sleep(1000);
			ServerConnection CThread = (ServerConnection) Naming.lookup(serverUrl);
			String currentlist=uf.initFile();
			if(currentlist.length()>filelist.length()){
				System.out.println("file changed, adding...");
				System.out.println(filelist);
				String[] oldR=filelist.split("\n");
				for(int i=0;i<oldR.length;i++){
					CThread.deleteRecord(oldR[i]);
				}
				String[] newR=currentlist.split("\n");
				for(int i=0;i<newR.length;i++){
					CThread.addRecord(newR[i]);
				}
				System.out.println("add completed!");
				
			}else{
				if(currentlist.length()<filelist.length()){
					System.out.println("file changed, deleting...");
					
					String[] oldR=filelist.split("\n");
					for(int i=0;i<oldR.length;i++){
						CThread.deleteRecord(oldR[i]);
					}
					String[] newR=currentlist.split("\n");
					for(int i=0;i<newR.length;i++){
						CThread.addRecord(newR[i]);
					}
					//String record=filelist.substring(currentlist.length()-1);
					

					System.out.println("delete completed!");
					
				}
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
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
