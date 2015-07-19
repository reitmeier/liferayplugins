package at.mailbox.sync;

public class EmailSettings {
	String userName;
	String password;
	String pop3Host;
	String pop3Port;
	String proxyHost;
	String proxyPort;
	
	public void setUserName(String userName) {
	
		this.userName = userName;
	}
	
	public void setPassword(String password) {
	
		this.password = password;
	}
	
	public void setPop3Host(String pop3Host) {
	
		this.pop3Host = pop3Host;
	}
	
	public void setPop3Port(String pop3Port) {
	
		this.pop3Port = pop3Port;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}
}
