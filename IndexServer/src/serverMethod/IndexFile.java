package serverMethod;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IndexFile {
	private String fileName="/Users/JIANG/Documents/workspace/IndexServer/server/file.txt";
	public IndexFile(){}
	
	//look up specific file in the file list
	public String lookupfile (String targetName){
		File file=new File(fileName);
		BufferedReader reader=null;	
		try {
			reader=new BufferedReader(new FileReader(file));
			String lineString=null;
			String result="";
			while((lineString=reader.readLine())!=null){
				String[]temp=lineString.split(" ");
				if(temp[0].equals(targetName)){
					result=result+temp[1]+" ";
					}
			}
			return result;
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
		return "reading file error";
	}
	
	public synchronized String addtofile (String updateInfo){
		try {
			updateInfo="\n"+updateInfo;
			FileWriter writer=new FileWriter(fileName,true);
			//write content need to be optimized!
			writer.write(updateInfo);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "succeed";
	}
 
	public synchronized String deletefromfile(String deleteInfo){
		File file=new File(fileName);
		BufferedReader reader=null;
		BufferedWriter writer=null;
		try {
			//loop the valued info in to arraylist
			reader=new BufferedReader(new FileReader(file));
			String lineString=null;
			List list=new ArrayList();
			while((lineString=reader.readLine())!=null){
				if(lineString.equals(deleteInfo)){
					continue;
				}else{
					list.add(lineString);
				}
			}	
			writer=new BufferedWriter(new FileWriter(file));
			for(int i=0;i<list.size();i++){
				writer.write(list.get(i).toString());
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "succeed";
	}
}
