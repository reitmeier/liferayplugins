create table MailboxSync_Mailbox (
	mailboxId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	host VARCHAR(75) null,
	port INTEGER,
	mailboxUser VARCHAR(75) null,
	mailboxUserSecret VARCHAR(75) null
);