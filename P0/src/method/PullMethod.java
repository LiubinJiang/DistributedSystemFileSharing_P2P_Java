package method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PullMethod {
	private String url="/Users/JIANG/Documents/workspace/proj3/P0/download/locallist";
	
	public String getVersionID(String filename){
		File file=new File(url);
		BufferedReader reader=null;
		String versionID=null;
		try {
			reader=new BufferedReader(new FileReader(file));
			String lineString=null;
			while((lineString=reader.readLine())!=null){
				String[]temp=lineString.split(" ");
				if(temp[0].equals(filename)){
					versionID=temp[4];
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

}
