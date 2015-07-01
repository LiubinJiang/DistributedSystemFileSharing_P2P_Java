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

public class UpdateList {
	private String originServerID=null;
	private String fileName=null;
	private String versionID=null;
	//TODO url differs
	private String url="/Users/JIANG/Documents/workspace/proj3/P1/download/pushlist";
	private String pulllist="/Users/JIANG/Documents/workspace/proj3/P1/download/pulllist";
	
	
	
	public String addtoList(String originServerID, String filename, String versionID){
		try {
			String info=filename+" "+originServerID+" "+versionID+" valid\n";
			FileWriter writer=new FileWriter(url,true);
			writer.write(info);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "succeed";
		
	}
	
	public String addtoPull(String originServerID, String filename, String TTL){
		long time=System.currentTimeMillis();
		try {
			String info=filename+" "+originServerID+" "+TTL+" "+String.valueOf(time)+" 0";
			FileWriter writer=new FileWriter(pulllist,true);
			writer.write(info+"\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "succeed";
	}
	
	public String deleteFromPull(String filename){
		File file=new File(pulllist);
		BufferedReader reader=null;
		BufferedWriter writer=null;
		String record=null;
		try {
			reader=new BufferedReader(new FileReader(file));
			String lineString=null;
			List list=new ArrayList();
			while((lineString=reader.readLine())!=null){
				String[]temp=lineString.split(" ");
				if(temp[0].equals(filename)){
					//TODO test
					System.out.println(lineString);
					record=lineString;
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
		
		
		return record;
		
	}
	
	public String updatePull(String record, String versionID){
		long time=System.currentTimeMillis();
		String[]temp=record.split(" ");
		String info=temp[0]+" "+temp[1]+" "+temp[2]+" "+String.valueOf(time)+" "+versionID;
		File file=new File(pulllist);
		BufferedWriter writer=null;
		try {
			writer=new BufferedWriter(new FileWriter(file));
			writer.write(info);
			writer.newLine();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "succeed";
	}
	
	
	

}
