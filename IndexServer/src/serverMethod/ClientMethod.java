package serverMethod;
public class ClientMethod {
	public ClientMethod(){}
	IndexFile f=new IndexFile();
	
	//look up files returns node id.
	public String Clientlookup(String filename){
		return f.lookupfile(filename);
		}
	//update index list after downloading.
	public String Clientadd(String updateInfo){
		return f.addtofile(updateInfo);
	}
	//update index list when delete files.
	public String Clientdelete(String deleteInfo){
		return f.deletefromfile(deleteInfo);
	}	

}
