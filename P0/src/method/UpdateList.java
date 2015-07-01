package method;

import java.io.FileWriter;
import java.io.IOException;

public class UpdateList {
	private String originServerID=null;
	private String fileName=null;
	private String versionID=null;
	//TODO url differs
	private String url="/Users/JIANG/Documents/workspace/proj3/P0/download/locallist";

	
	
	
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
	

}
