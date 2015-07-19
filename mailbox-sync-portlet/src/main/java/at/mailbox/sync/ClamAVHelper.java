package at.mailbox.sync;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.PropsUtil;

import fi.solita.clamav.ClamAVClient;

public final class ClamAVHelper {

	public static Logger logger = Logger.getLogger(ClamAVHelper.class.getName());

	public static byte[] getCheckedContent(byte[] input, Message message) {
		logger.info("getCheckedContent Start");
		String clamvActivation = getPortalProperty("clamav.activation");
		boolean activation = clamvActivation != null ? Boolean.valueOf(clamvActivation) : false;
		if (!activation) {
			return input;
		}
		try {
			String clamavHostname = getPortalProperty("clamav.hostname");
			String clamavPort = getPortalProperty("clamav.port");
			String clamavVirusmessage = getPortalProperty("clamav.virusmessage");
			ClamAVClient cl = new ClamAVClient(clamavHostname, Integer.valueOf(clamavPort));
			byte[] reply;
			reply = cl.scan(input);
			if (!ClamAVClient.isCleanReply(reply)) {
				// throw new Exception("aaargh. Something was found: ", reply);
				logger.warn("getCheckedContent | From=" + message.getFrom() + " | Subject= " + message.getSubject() + " | " + clamavVirusmessage);
				return clamavVirusmessage.getBytes();
			} else {
				logger.info("getCheckedContent End OK");
				return input;
			}
		} catch (UnsupportedEncodingException e) {
			// e.printStackTrace();
			logger.warn("getCheckedContent Could not scan the input: " + e.getClass().getName());
			throw new RuntimeException("Could not scan the input, UnsupportedEncodingException", e);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.warn("getCheckedContent Could not scan the input:" + e.getClass().getName());
			throw new RuntimeException("Could not scan the input", e);
		}
	}

	public static void logClamAVClientStatus() {
		try {
			String clamavHostname = getPortalProperty("clamav.hostname");
			String clamavPort = getPortalProperty("clamav.port");
			ClamAVClient cl = new ClamAVClient(clamavHostname, Integer.valueOf(clamavPort));
			if (cl != null) {
				logger.info("ClamAvClient ping=" + cl.ping());
				byte[] reply;
				String testString = "TEST";
				reply = cl.scan(testString.getBytes());
				logger.info("ClamAvClient.scan(" + testString + ")=" + reply);
				logger.info("ClamAVClient.isCleanReply(" + reply + ")=" + ClamAVClient.isCleanReply(reply));
			} else {
				logger.info("ClamAvClient is null");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("ClamAvClient Exception" + e.getClass().getName());
		}

	}

	private static String getPortalProperty(String name) {
		return PropsUtil.get(name);
	}
}
