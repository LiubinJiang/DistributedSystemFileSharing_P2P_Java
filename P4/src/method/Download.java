/*
 * I personally prefer fat client thin server, so this method is separate from P1_Implementation.java.  
 * This class deals all the method that can run locally.  
 * The upload method transfer the target file into byte array stream and store them in memory.  
 * Later for use of P1_Implementation.java.
 */

package method;

import implem.FileInfoImplem;
import interf.FileInfo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Download {
	
	@SuppressWarnings("resource")
	public FileInfo upload(String name){
		String filepath="/Users/JIANG/Documents/workspace/P4/P4";
		String uploadFile=filepath+"/"+name;
		System.out.println(uploadFile);
		FileInfo fi=new FileInfoImplem();
		BufferedInputStream input=null;
	
			File file=new File(uploadFile);
			byte[] content=new byte[(int)file.length()];
			try {
				input=new BufferedInputStream(new FileInputStream(file));
				System.out.println(input.read(content));
				input.read(content);
				fi.setFileInfo(name, content);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(input!=null){
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					input=null;
				}
			}
			
			return fi;
	}

}
