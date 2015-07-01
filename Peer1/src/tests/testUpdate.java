package tests;

import thread.CheckThread;
import method.UpdateFile;

public class testUpdate {

	public static void main(String[] args) {
		
		UpdateFile uf=new UpdateFile();
		while(true){
			String filelist=uf.initFile();
			new CheckThread(filelist);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
