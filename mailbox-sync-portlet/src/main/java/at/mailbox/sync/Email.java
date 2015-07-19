package at.mailbox.sync;

import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

public class Email {
	public static class Attachment {
		String fileName;
		byte[] content;
		
		public String getFileName() {
			return fileName;
		}
		
		public byte[] getContent() {
			return content;
		}
	}

	String body;
	String subject;
	String from;
	Date sentDate;
	List<Attachment> attachments;
	
	public String getSubject() {
		return this.subject;
	}
	
	public String getFrom() {
		return this.from;
	}
	
	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public String getBody() {
		return this.body;
	}
	
	public Date getSentDate() {
		return this.sentDate;
	}
	
	public static String getExtension(String filename) {
		if (filename!=null) {
			String extension = FilenameUtils.getExtension(filename);
			String [] parts = extension.split("\\?");
			extension = parts[0];
			return  extension; 
		}
		return null;
	}
}
