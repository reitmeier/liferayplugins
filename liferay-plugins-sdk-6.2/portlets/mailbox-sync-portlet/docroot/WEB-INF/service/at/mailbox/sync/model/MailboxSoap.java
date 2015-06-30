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

package at.mailbox.sync.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.mailbox.sync.service.http.MailboxServiceSoap}.
 *
 * @author Claus Reitmeier
 * @see at.mailbox.sync.service.http.MailboxServiceSoap
 * @generated
 */
public class MailboxSoap implements Serializable {
	public static MailboxSoap toSoapModel(Mailbox model) {
		MailboxSoap soapModel = new MailboxSoap();

		soapModel.setMailboxId(model.getMailboxId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setHost(model.getHost());
		soapModel.setPort(model.getPort());
		soapModel.setMailboxUser(model.getMailboxUser());
		soapModel.setMailboxUserSecret(model.getMailboxUserSecret());

		return soapModel;
	}

	public static MailboxSoap[] toSoapModels(Mailbox[] models) {
		MailboxSoap[] soapModels = new MailboxSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MailboxSoap[][] toSoapModels(Mailbox[][] models) {
		MailboxSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MailboxSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MailboxSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MailboxSoap[] toSoapModels(List<Mailbox> models) {
		List<MailboxSoap> soapModels = new ArrayList<MailboxSoap>(models.size());

		for (Mailbox model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MailboxSoap[soapModels.size()]);
	}

	public MailboxSoap() {
	}

	public long getPrimaryKey() {
		return _mailboxId;
	}

	public void setPrimaryKey(long pk) {
		setMailboxId(pk);
	}

	public long getMailboxId() {
		return _mailboxId;
	}

	public void setMailboxId(long mailboxId) {
		_mailboxId = mailboxId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getHost() {
		return _host;
	}

	public void setHost(String host) {
		_host = host;
	}

	public int getPort() {
		return _port;
	}

	public void setPort(int port) {
		_port = port;
	}

	public String getMailboxUser() {
		return _mailboxUser;
	}

	public void setMailboxUser(String mailboxUser) {
		_mailboxUser = mailboxUser;
	}

	public String getMailboxUserSecret() {
		return _mailboxUserSecret;
	}

	public void setMailboxUserSecret(String mailboxUserSecret) {
		_mailboxUserSecret = mailboxUserSecret;
	}

	private long _mailboxId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private String _host;
	private int _port;
	private String _mailboxUser;
	private String _mailboxUserSecret;
}