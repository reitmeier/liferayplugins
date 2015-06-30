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

package at.mailbox.sync.model.impl;

import at.mailbox.sync.model.Mailbox;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Mailbox in entity cache.
 *
 * @author Claus Reitmeier
 * @see Mailbox
 * @generated
 */
public class MailboxCacheModel implements CacheModel<Mailbox>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{mailboxId=");
		sb.append(mailboxId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", host=");
		sb.append(host);
		sb.append(", port=");
		sb.append(port);
		sb.append(", mailboxUser=");
		sb.append(mailboxUser);
		sb.append(", mailboxUserSecret=");
		sb.append(mailboxUserSecret);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Mailbox toEntityModel() {
		MailboxImpl mailboxImpl = new MailboxImpl();

		mailboxImpl.setMailboxId(mailboxId);
		mailboxImpl.setGroupId(groupId);
		mailboxImpl.setCompanyId(companyId);
		mailboxImpl.setUserId(userId);

		if (userName == null) {
			mailboxImpl.setUserName(StringPool.BLANK);
		}
		else {
			mailboxImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			mailboxImpl.setCreateDate(null);
		}
		else {
			mailboxImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mailboxImpl.setModifiedDate(null);
		}
		else {
			mailboxImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			mailboxImpl.setDescription(StringPool.BLANK);
		}
		else {
			mailboxImpl.setDescription(description);
		}

		if (host == null) {
			mailboxImpl.setHost(StringPool.BLANK);
		}
		else {
			mailboxImpl.setHost(host);
		}

		mailboxImpl.setPort(port);

		if (mailboxUser == null) {
			mailboxImpl.setMailboxUser(StringPool.BLANK);
		}
		else {
			mailboxImpl.setMailboxUser(mailboxUser);
		}

		if (mailboxUserSecret == null) {
			mailboxImpl.setMailboxUserSecret(StringPool.BLANK);
		}
		else {
			mailboxImpl.setMailboxUserSecret(mailboxUserSecret);
		}

		mailboxImpl.resetOriginalValues();

		return mailboxImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mailboxId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		host = objectInput.readUTF();
		port = objectInput.readInt();
		mailboxUser = objectInput.readUTF();
		mailboxUserSecret = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(mailboxId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (host == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(host);
		}

		objectOutput.writeInt(port);

		if (mailboxUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mailboxUser);
		}

		if (mailboxUserSecret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mailboxUserSecret);
		}
	}

	public long mailboxId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String host;
	public int port;
	public String mailboxUser;
	public String mailboxUserSecret;
}