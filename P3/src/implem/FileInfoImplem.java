/*
 * Implement FileInfo.java interface from interf_1.
 */

package implem;

import interf.FileInfo;

public class FileInfoImplem implements FileInfo {

	private String name=null;
	private byte[] content=null;

	@Override
	public void setFileInfo(String name, byte[] content) {
		this.name=name;
		this.content=content;
		
	}

	@Override
	public String Name() {
		return name;
	}

	@Override
	public byte[] Content() {
		return content;
	}

}
