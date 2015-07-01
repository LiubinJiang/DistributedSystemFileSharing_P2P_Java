/*
 * Define a file entity that contains property of file name and file content.  
 * The reason we can not simply define it as a normal entity is because 
 * JAVA support limited file transaction method.  
 * Define a file entity as a interface to extends Serializable 
 * to make sure the file transaction¡¯s integrity and completion.
 * byte[] Content() is to store the content of file as a byte array type.
 */

package interf;
import java.io.Serializable;

public interface FileInfo extends Serializable{
	String Name();
	byte[] Content();
	
	public void setFileInfo(String name,byte[] content);

}
