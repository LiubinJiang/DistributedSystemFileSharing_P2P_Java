package method;

import inplem_2.FileInfoImplem;
import interf_2.FileInfo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class PMethod {
	
	@SuppressWarnings("resource")
	public FileInfo upload(String name){
		String filepath="/Users/JIANG/Documents/workspace/Peer2/P2";
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
	
	private static String readString(String prompt){
		Scanner scanner =new Scanner(System.in);
		System.out.print(prompt);
		return scanner.nextLine();
	}

}
