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

create table MailboxSync_Task (
	taskId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status VARCHAR(75) null,
	description VARCHAR(75) null,
	mailboxId LONG,
	permissionUserGroupId LONG,
	eventCalendarId LONG,
	documentFolderId LONG,
	webcontentFolderId LONG,
	vocabularyId LONG,
	period LONG,
	clamavServerIP VARCHAR(75) null,
	clamavPort INTEGER
);