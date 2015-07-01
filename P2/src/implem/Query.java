package implem;

import interf.MessageInfo;
import interf.QueryInfo;

public class Query implements QueryInfo {
	private MessageInfo messageID;
	private Integer TTL;
	private String filename;

	public Query(MessageInfo messageID, Integer TTL, String filename) {
		this.messageID=messageID;
		this.TTL=TTL;
		this.filename=filename;
	}

	public MessageInfo getMessageID() {
		return messageID;
	}

	public void setMessageID(MessageInfo messageID) {
		this.messageID = messageID;
	}

	public Integer getTTL() {
		return TTL;
	}

	public void setTTL(Integer tTL) {
		TTL = tTL;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	

}
