package method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LocalLookup {
	//TODO different peer different dirc
	private String pulllist="/Users/JIANG/Documents/workspace/proj3/P1/download/pulllist";
	public LocalLookup(){
	}
	
/*	
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
	*/
	public String LookupResult(String filename){
		String result="";
		String record=checkFile(filename);
		if(record.equals("")){
			result="miss";
			return result;
		}else{
			String valid=checkValid(record);
			if(valid=="valid"){
				result="hit";
				return result;
			}else{
				result="expired";
				return result;
				}
		}
		
	}
	
	
	public String checkValid(String record){
		String result="valid";
		String [] temp=record.split(" ");
		long currentTime=System.currentTimeMillis();
		if(Long.parseLong(temp[3])+Integer.parseInt(temp[2])>currentTime){
			result="valid";
		}else
			result="invalid";
		return result;
	}
	
	//MODIFIED
	public String checkFile(String filename){
		File file=new File(pulllist);
		BufferedReader reader=null;	
		String record="";
		try {
			reader=new BufferedReader(new FileReader(file));
			String lineString=null;
			while((lineString=reader.readLine())!=null){
				String[]temp=lineString.split(" ");
				if(temp[0].equals(filename)){
					record=lineString;
					}
			}
		} catch (FileNotFoundException e) {
			System.out.println("file find error");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader!=null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return record;
		
	}
	
	

}
