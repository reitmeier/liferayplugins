package at.mailbox.sync;

import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.PropsUtil;

public class SyncEmailsTask extends TimerTask {

	Logger logger = Logger.getLogger(SyncEmailsTask.class.getName());
	
	@Override
	public void run() {
		loggingConfig();
		String mailActivation=getPortalProperty("mail.activation");
		boolean activation=mailActivation != null ? Boolean.valueOf(mailActivation) : false;
		if (activation) {
			EmailSettings settings = new EmailSettings();
			settings.setUserName(getPortalProperty("mail.userName"));
			settings.setPassword(getPortalProperty("mail.password"));
			settings.setPop3Host(getPortalProperty("mail.pop3Host"));
			settings.setPop3Port(getPortalProperty("mail.pop3Port"));
			settings.setProxyHost(getPortalProperty("mail.proxyHost"));
			settings.setProxyPort(getPortalProperty("mail.proxyPort"));
			try {
				new EmailReader(settings).read(new SyncEmailHandler());
			} catch (Exception e) {
				logger.error(e.getStackTrace());
			}
		}
		
	}
	
	private void loggingConfig() {
		logger.info("mail.activation="+getPortalProperty("mail.activation"));
		logger.info("mail.userName="+getPortalProperty("mail.userName"));
		logger.info("mail.password="+getPortalProperty("mail.password"));
		logger.info("mail.pop3Host="+getPortalProperty("mail.pop3Host"));
		logger.info("mail.pop3Port="+getPortalProperty("mail.pop3Port"));
		logger.info("mail.proxyHost="+getPortalProperty("mail.proxyHost"));
		logger.info("mail.proxyPort="+getPortalProperty("mail.proxyPort"));
		
		logger.info("clamav.activation="+getPortalProperty("clamav.activation"));
		logger.info("clamav.hostname="+ getPortalProperty("clamav.hostname"));
		logger.info("clamav.port="+getPortalProperty("clamav.port"));
		//logger.info("clamav.virusmessage="+getPortalProperty("clamav.virusmessage"));
		ClamAVHelper.logClamAVClientStatus();
	}
	
	
	private static String getPortalProperty(String name) {
		return PropsUtil.get(name);
	}

}
