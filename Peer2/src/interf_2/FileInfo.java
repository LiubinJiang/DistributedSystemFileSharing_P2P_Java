package interf_2;
import java.io.Serializable;

public interface FileInfo extends Serializable{
	String Name();
	byte[] Content();
	
	public void setFileInfo(String name,byte[] content);

}
