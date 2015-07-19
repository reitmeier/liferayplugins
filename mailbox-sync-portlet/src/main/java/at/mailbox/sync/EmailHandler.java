package at.mailbox.sync;

public abstract class EmailHandler {

	public abstract void process(Email email) throws Exception;
}
 