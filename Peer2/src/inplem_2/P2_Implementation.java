package inplem_2;

import interf_2.FileInfo;
import interf_2.P2_Connection;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import method.PMethod;

public class P2_Implementation extends UnicastRemoteObject implements P2_Connection {
	
	public P2_Implementation() throws RemoteException {
		super();
	}

	public void uploadFile(String name,Integer node_id) throws RemoteException {
		FileInfo fi=new FileInfoImplem();
		PMethod pm=new PMethod();
		String subDir="";
		switch(node_id){
		case 1: subDir="Peer1/P1";break;
		case 2: subDir="Peer2/P2";break;
		case 3: subDir="Peer3/P3";break;
		default: subDir="unknown";
		}
		fi=pm.upload(name);
	
		BufferedOutputStream output=null;
		String fileName=fi.Name();
		byte[] fileContent=fi.Content();		
		System.out.println("filename:"+fileName);
		System.out.println("content:"+fileContent);
		try{
			String filePath="/Users/Jiang/Documents/workspace/"+subDir+"/"+name;
			File file=new File(filePath);
			if(!file.exists()){
				//System.out.println("file not exists");
					file.createNewFile();
					}
				
					output=new BufferedOutputStream(new FileOutputStream(file));
					output.write(fileContent);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(Exception ex){
					throw new RemoteException(ex.getLocalizedMessage());
				}finally{
					if(output!=null){
						try{
							output.close();
							output=null;
						}catch(Exception ex){
							
						}
					}
				}
			
			System.out.println("write finish");		
		
	}

	@Override
	public void downloadFile() throws RemoteException {
		//server upload
		//???
		PMethod pm=new PMethod();
		pm.upload("jiang.txt");
		//client download
		System.out.println("download");
		
	}

}
