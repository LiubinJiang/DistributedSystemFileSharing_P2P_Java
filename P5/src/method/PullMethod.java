package method;

import interf.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class PullMethod {
	private static String serverP0="//localhost:8810/P0";
	public String pullChanges(String filename, String serverID){
		//TODO
		P5Entry p10;
		String newID=null;
		String originalID=null;
		String result=null;
		//try {
			/*TODO test
			p10 = (P0Entry)Naming.lookup(serverP0);
			//global record
			newID=p10.getRecord(filename);*/
			//TODO
			newID="3";
			//local record
			LocalLookup ll=new LocalLookup();
			String [] tempID=ll.checkFile(filename).split(" ");
			originalID=tempID[4];
			if(newID.equals(originalID)){
				System.out.println("already up-to-date");
				//TODO
				//更新时间
			}else{
				System.out.println("invalid, update or delete");
				String option=readString("$");
				if(option.equals("delete")){
					UpdateList ul=new UpdateList();
					System.out.println("deleting "+ul.deleteFromPull(filename));
				}else if(option.equals("update")){
					UpdateList ul=new UpdateList();
					String record=ul.deleteFromPull(filename);
					System.out.println("update "+filename+" "+ul.updatePull(record, newID));
				}
			}
		/*} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//调用server方法读取当前verid
		return result;
		
	}
	private static String readString(String prompt){
		Scanner scanner =new Scanner(System.in);
		System.out.print(prompt);
		return scanner.nextLine();
	}
}
