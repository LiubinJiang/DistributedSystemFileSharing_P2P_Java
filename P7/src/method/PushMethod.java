package method;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PushMethod {
	//TODO differs
	private String pushlist="/Users/JIANG/Documents/workspace/proj3/P1/download/pushlist"; 

	
	public void updatePushList(String filename){
		String originalRecord=lookupRecord(filename);
		System.out.println(filename+" invalid received!");
		if(originalRecord.equals("none"))
			//nothing
			;
		else{
			changetoInvalid(originalRecord);
			
		}
	}
	
	public String lookupRecord(String filename){
		File file=new File(pushlist);
		BufferedReader reader=null;	
		String result="none";
		try {
			reader=new BufferedReader(new FileReader(file));
			String lineString=null;
			
			while((lineString=reader.readLine())!=null){
				String[]temp=lineString.split(" ");
				if(temp[0].equals(filename)){
					result=lineString;
					break;
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
		return result;
	}
	
	public void changetoInvalid(String record){
		String[]temp=record.split(" ");
		String newRecord=temp[0]+" "+temp[1]+" "+temp[2]+" invalid";
		File file=new File(pushlist);
		BufferedReader reader=null;
		BufferedWriter writer=null;
		try {
			//loop the valued info in to arraylist
			reader=new BufferedReader(new FileReader(file));
			String lineString=null;
			List list=new ArrayList();
			while((lineString=reader.readLine())!=null){
				if(lineString.equals(record)){
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
			writer.write(newRecord);
			writer.newLine();
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
