/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package at.mailbox.sync.service.impl;

import java.util.Date;
import java.util.List;

import at.mailbox.sync.model.Mailbox;
import at.mailbox.sync.service.MailboxLocalServiceUtil;
import at.mailbox.sync.service.base.MailboxLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the mailbox local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.mailbox.sync.service.MailboxLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Claus Reitmeier
 * @see at.mailbox.sync.service.base.MailboxLocalServiceBaseImpl
 * @see at.mailbox.sync.service.MailboxLocalServiceUtil
 */
public class MailboxLocalServiceImpl extends MailboxLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.mailbox.sync.service.MailboxLocalServiceUtil} to access the mailbox local service.
	 */
	
public Mailbox addMailbox(long userId, long groupId, String description, String host, int port, String mailboxUser, String mailboxUserSecret , ServiceContext serviceContext)	

	throws PortalException, SystemException {
	User user = userPersistence.findByPrimaryKey(userId);
	Date now = new Date();
	long mailboxId = counterLocalService.increment(Mailbox.class.getName());
	Mailbox mailbox = mailboxPersistence.create(mailboxId);
	mailbox.setDescription(description);
	mailbox.setHost(host);
	mailbox.setPort(port);
	mailbox.setMailboxUser(mailboxUser);
	mailbox.setMailboxUserSecret(mailboxUserSecret);
	mailbox.setGroupId(groupId);
	mailbox.setCompanyId(user.getCompanyId());
	mailbox.setUserId(user.getUserId());
	mailbox.setCreateDate(serviceContext.getCreateDate(now));
	mailbox.setModifiedDate(serviceContext.getModifiedDate(now));
	super.addMailbox(mailbox);
	//Resources
	boolean portletActions = false;
	boolean groupPermission = true;
	boolean guestPermission = false;
	//resourceLocalService.addResources(mailbox.getCompanyId(), mailbox.getGroupId(), mailbox.getUserId(), Mailbox.class.getName(), mailbox.getMailboxId(), portletActions,groupPermission,guestPermission);
	return mailbox;
}

public Mailbox deleteMailbox (Mailbox mailbox) throws SystemException {
	return mailboxPersistence.remove(mailbox);
}
public Mailbox deleteMailbox (long mailboxId)
		throws PortalException, SystemException {
	Mailbox mailbox = mailboxPersistence.findByPrimaryKey(mailboxId);
	return deleteMailbox(mailbox);
}

public Mailbox getMaibox(long mailboxId) 
		throws SystemException, PortalException {
	return mailboxPersistence.findByPrimaryKey(mailboxId);
	
}

public List<Mailbox> getMailboxByGroupId(long groupId) throws SystemException {
	return mailboxPersistence.findByGroupId(groupId);
}

public int getMailboxCountByGroupId(long groupId) throws SystemException {
	return mailboxPersistence.countByGroupId(groupId);
}

public Mailbox updateMailbox(long userId, long mailboxId, String description, String host, int port, String mailboxUser, String mailboxUserSecret , ServiceContext serviceContext) 
		throws PortalException, SystemException {
	User user = userPersistence.findByPrimaryKey(userId);
	Date now = new Date();
	Mailbox mailbox = MailboxLocalServiceUtil.fetchMailbox(mailboxId);
	mailbox.setModifiedDate(serviceContext.getModifiedDate(now));
	mailbox.setDescription(description);
	mailbox.setHost(host);
	mailbox.setPort(port);
	mailbox.setMailboxUser(mailboxUser);
	mailbox.setMailboxUserSecret(mailboxUserSecret);
	super.updateMailbox(mailbox);
	return mailbox;
}


}