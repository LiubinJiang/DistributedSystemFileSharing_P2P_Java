package method;

import java.io.File;

public class UpdateFile {
	private String path="/Users/JIANG/Documents/workspace/Peer1/P1";
	public UpdateFile(){}
	
	public String initFile(){
		File file=new File(path);
		File[] list=file.listFiles();
		String result="";
		for(int i=1;i<list.length;i++){
			String temp;
			temp=list[i].getAbsolutePath();
			temp=temp.substring(42);
			result=result+temp+" "+"1"+"\n";			
		}
		return result;
	}

}
