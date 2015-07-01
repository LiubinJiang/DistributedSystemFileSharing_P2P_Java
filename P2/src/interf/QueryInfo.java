package interf;
import java.io.Serializable;

public interface QueryInfo extends Serializable{
	MessageInfo messageID=null;
	Integer TTL=null;
	String filename=null;

	//public void Query(MessageInfo messageID, Integer TTL, String filename);

}
