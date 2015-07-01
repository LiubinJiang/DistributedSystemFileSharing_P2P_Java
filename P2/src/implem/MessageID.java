package implem;

import interf.MessageInfo;

public class MessageID implements MessageInfo {
	private Integer PeerID=2;
	private Integer SequenceNumber=-1;
	
	
	public MessageID(Integer sequenceNumber) {
		this.SequenceNumber=SequenceNumber;
		PeerID=2;
	}

	
	public Integer getPeerID() {
		return PeerID;
	}
	public void setPeerID(Integer peerID) {
		PeerID = peerID;
	}
	public Integer getSequenceNumber() {
		return SequenceNumber;
	}
	public void setSequenceNumber(Integer sequenceNumber) {
		SequenceNumber = sequenceNumber;
	}


	
	
	

}
