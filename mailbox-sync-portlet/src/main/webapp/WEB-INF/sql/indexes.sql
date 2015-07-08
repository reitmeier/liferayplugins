create index IX_F31BD380 on MailboxSync_Mailbox (groupId);

create index IX_86C464E4 on MailboxSync_Task (mailboxId);
create index IX_D3517FCA on MailboxSync_Task (mailboxId, status);