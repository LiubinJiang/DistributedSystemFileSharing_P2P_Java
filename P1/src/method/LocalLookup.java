package method;

import java.io.File;

public class LocalLookup {
	//TODO different peer different dirc
	private String path="/Users/JIANG/Documents/workspace/P1/P1";
	public LocalLookup(){
	}
	
	
	public String[] getFileList(){
		
		File file=new File(path);
		File[] list=file.listFiles();
		String [] result=new String[list.length];
		for(int i=0;i<list.length;i++){
			String temp;
			temp=list[i].getAbsolutePath();
			System.out.println(temp.substring(39));
			result[i]=temp.substring(39);	
		}
		return result;
	}
	
	public String checkFile(String filename){
		String result="miss";
		String[] filelist=getFileList();
		for(int i=0;i<filelist.length;i++){
			if(filelist[i].equals(filename)){
				result="hit";
			}
			else
				continue;
		}
		
		
		return result;
		
	}

}
