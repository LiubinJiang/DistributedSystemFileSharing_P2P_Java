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
import java.util.Scanner;

public class Modified {
	//TODO differ url
	private String url="/Users/JIANG/Documents/workspace/proj3/P0/P0/";
	//private String versionID=null;
	
	public String updateVersion(String filename){
		//TODO get version id from local list
		String versionID=getVersionID(filename);	
		Integer vid=Integer.parseInt(versionID);
		vid=vid+1;
		System.out.println("*******modified mode******");
		String info=readString("append:");
		System.out.println("*******modified finish******");
		try {
			FileWriter writer=new FileWriter(url+filename);
			writer.write(info);
			writer.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateLocalList(versionID,filename);
		
		return vid.toString();
	}
	
	public String getVersionID(String filename){
		File file=new File(url+"locallist");
		BufferedReader reader=null;
		String versionID=null;
		try {
			reader=new BufferedReader(new FileReader(file));
			String lineString=null;
			while((lineString=reader.readLine())!=null){
				String[]temp=lineString.split(" ");
				if(temp[0].equals(filename)){
					versionID=temp[1];
					}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return versionID;
	}
	
	public void updateLocalList(String versionID,String filename){
		Integer vid=Integer.parseInt(versionID);
		vid=vid+1;
		File file=new File(url+"locallist");
		BufferedReader reader=null;
		BufferedWriter writer=null;
			//loop the valued info in to arraylist
			try {
				reader=new BufferedReader(new FileReader(file));
				String lineString=null;
				List list=new ArrayList();
				while((lineString=reader.readLine())!=null){
					if(lineString.equals(filename+" "+versionID)){
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
				writer.write(filename+" "+vid.toString());
				writer.newLine();
				writer.flush();
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	
	private static String readString(String prompt){
		Scanner scanner =new Scanner(System.in);
		System.out.print(prompt);
		return scanner.nextLine();
	}

}


