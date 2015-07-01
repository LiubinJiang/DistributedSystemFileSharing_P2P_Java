package tests;

import method.UpdateFile;
import thread.CheckThread;

public class AutoUpdateTest {

	public static void main(String[] args) {
		UpdateFile uf=new UpdateFile();
		
		CheckThread ct=new CheckThread(uf.initFile());

	}

}
