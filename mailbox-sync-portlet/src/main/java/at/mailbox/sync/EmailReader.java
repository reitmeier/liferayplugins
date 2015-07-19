package at.mailbox.sync;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import at.mailbox.sync.Email.Attachment;

public class EmailReader {

	Logger logger = Logger.getLogger(EmailReader.class.getName());

	private static final String POP3 = "pop3";

	private EmailSettings settings;

	public EmailReader(EmailSettings settings) {
		super();
		this.settings = settings;
	}

	public void read(EmailHandler handler) {
		try {
			Properties props = new Properties();
			props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.pop3.socketFactory.fallback", "false");
			props.put("mail.pop3.socketFactory.port", this.settings.pop3Port);
			props.put("mail.pop3.port", this.settings.pop3Port);
			props.put("mail.pop3.host", this.settings.pop3Host);
			props.put("mail.pop3.user", this.settings.userName);
			props.put("mail.store.protocol", POP3);
			props.put("mail.pop3.socks.host", this.settings.proxyHost);
			props.put("mail.pop3.socks.port", this.settings.proxyPort);
			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore(POP3);
			logger.info("read store.connect(" + this.settings.pop3Host + "," + this.settings.userName + "," + this.settings.password);
			store.connect(this.settings.pop3Host, this.settings.userName, this.settings.password);
			Folder inbox = store.getFolder("INBOX");
			logger.info("read inbox.open:" + inbox.getFullName());
			inbox.open(Folder.READ_WRITE);
			Message[] messages = inbox.getMessages();
			logger.info("read messages:" + ((messages != null) ? messages.length : "null"));
			for (Message message : messages) {
				Email email = new Email();
				email.sentDate = message.getSentDate();
				email.from = message.getFrom()[0].toString();
				String messageContent = getBody(message);
				email.body = (messageContent != null && messageContent.length() > 0) ? messageContent : message.getSubject();
				email.subject = message.getSubject();
				email.attachments = this.getAttachments(message);
				logger.info("read handler.process(" + email.getFrom() + "," + email.getSubject() + "," + ((email.getAttachments() != null) ? email.getAttachments().size() : null) + ")");
				try {
					handler.process(email);
					message.setFlag(Flags.Flag.DELETED, true);
				} catch (Exception e) {
					message.setFlag(Flags.Flag.DELETED, true);
					logger.error(e.getClass().getName() + " read handler.process(" + email.getFrom() + "," + email.getSubject() + "," + ((email.getAttachments() != null) ? email.getAttachments().size() : null) + ")", e);
				}
			}
			inbox.close(true);
			store.close();
		} catch (Exception e) {
			logger.info("read Exception" + e.getClass().getName());
			throw new RuntimeException(e);
		}
	}

	private List<Email.Attachment> getAttachments(Message message) throws Exception {
		List<Email.Attachment> result = new ArrayList<Email.Attachment>();

		Object contentObject = message.getContent();
		Multipart multipart = null;
		if (contentObject instanceof String) {
			return result;
		} else if (contentObject instanceof Multipart) {
			multipart = (Multipart) message.getContent();
		} else {
			return result;
		}
		for (int i = 0; i < multipart.getCount(); i++) {
			BodyPart bodyPart = multipart.getBodyPart(i);
			if (!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition()) && !StringUtils.isNotBlank(bodyPart.getFileName()))
				continue;
			Attachment attachment = new Attachment();
			attachment.fileName = bodyPart.getFileName();
			byte[] content = IOUtils.toByteArray(bodyPart.getInputStream());
			try {
				attachment.content = ClamAVHelper.getCheckedContent(content, message);
			} catch (Exception e) {
				attachment.content = null;
			}

			result.add(attachment);
		}
		return result;
	}

	private String getBody(Message message) {

		try {
			Object content = message.getContent();
			if (content instanceof String) {
				String body = (String) content;
				logger.info("getBody instanceof String" + body);
				return body;
			} else if (content instanceof Multipart) {
				// Make sure to cast to it's Multipart derivative
				String body = parseMultipart((Multipart) content);
				logger.info("getBody instanceof Multipart ");// + body);
				return body;
			} else {
				return "Body not parsed";
			}

		} catch (MessagingException e) {
			e.printStackTrace();
			return "Body Parse error:" + e.getClass().getName();
		} catch (IOException e) {
			e.printStackTrace();
			return "Body Parse error:" + e.getClass().getName();
		}

	}

	public String parseMultipart(Multipart mPart) throws MessagingException, IOException {
		// Loop through all of the BodyPart's
		String bodyContent = "";
		for (int i = 0; i < mPart.getCount(); i++) {
			// Grab the body part
			BodyPart bp = mPart.getBodyPart(i);
			// Grab the disposition for attachments
			String disposition = bp.getDisposition();
			// It's not an attachment
			if (disposition == null && bp instanceof MimeBodyPart) {
				logger.info("parseMultipart disposition == null && bp instanceof MimeBodyPart BodyPart(" + i + ").getContentType()=" + bp.getContentType());
				MimeBodyPart mbp = (MimeBodyPart) bp;
				// Time to grab and edit the body
				if (mbp.isMimeType("text/plain")) {
					logger.info("parseMultipart text/plain MimeBodyPart(" + i + ").getContentType()=" + mbp.getContentType());
					// Grab the body containing the text version
					String body = (String) mbp.getContent();
					// Add our custom message
					bodyContent += body;
				} else if (mbp.isMimeType("text/html")) {
					logger.info("parseMultipart text/html MimeBodyPart(" + i + ").getContentType()=" + mbp.getContentType());
					// Grab the body containing the HTML version
					String body = (String) mbp.getContent();
					// Add our custom message to the HTML before
					// the closing </body>

					// bodyContent += body; //html text is not included in body.
					// Reset the content

				} else {
					if (mbp.getContent() instanceof MimeMultipart) {
						logger.info("parseMultipart MimeBodyPart is instanceof MimeMultipart  MimeBodyPart(" + i + ").getContentType()=" + mbp.getContentType());
						MimeMultipart mimeMultiPart = (MimeMultipart) mbp.getContent();
						bodyContent += parseMultipart((Multipart) mbp.getContent());
					} else {
						logger.info("parseMultipart MimeBodyPart is ? MimeBodyPart(" + i + ").getContentType()=" + mbp.getContentType());
						bodyContent += "-body parser dead end";
					}
				}
			} else {
				logger.info("parseMultipart: disposition=" + disposition + " ; BodyPart(" + i + ").getContentType()=" + bp.getContentType());
			}
		}
		return bodyContent;
	}
}
