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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Mailbox}.
 * </p>
 *
 * @author Claus Reitmeier
 * @see Mailbox
 * @generated
 */
public class MailboxWrapper implements Mailbox, ModelWrapper<Mailbox> {
	public MailboxWrapper(Mailbox mailbox) {
		_mailbox = mailbox;
	}

	@Override
	public Class<?> getModelClass() {
		return Mailbox.class;
	}

	@Override
	public String getModelClassName() {
		return Mailbox.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mailboxId", getMailboxId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("host", getHost());
		attributes.put("port", getPort());
		attributes.put("mailboxUser", getMailboxUser());
		attributes.put("mailboxUserSecret", getMailboxUserSecret());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mailboxId = (Long)attributes.get("mailboxId");

		if (mailboxId != null) {
			setMailboxId(mailboxId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String host = (String)attributes.get("host");

		if (host != null) {
			setHost(host);
		}

		Integer port = (Integer)attributes.get("port");

		if (port != null) {
			setPort(port);
		}

		String mailboxUser = (String)attributes.get("mailboxUser");

		if (mailboxUser != null) {
			setMailboxUser(mailboxUser);
		}

		String mailboxUserSecret = (String)attributes.get("mailboxUserSecret");

		if (mailboxUserSecret != null) {
			setMailboxUserSecret(mailboxUserSecret);
		}
	}

	/**
	* Returns the primary key of this mailbox.
	*
	* @return the primary key of this mailbox
	*/
	@Override
	public long getPrimaryKey() {
		return _mailbox.getPrimaryKey();
	}

	/**
	* Sets the primary key of this mailbox.
	*
	* @param primaryKey the primary key of this mailbox
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_mailbox.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mailbox ID of this mailbox.
	*
	* @return the mailbox ID of this mailbox
	*/
	@Override
	public long getMailboxId() {
		return _mailbox.getMailboxId();
	}

	/**
	* Sets the mailbox ID of this mailbox.
	*
	* @param mailboxId the mailbox ID of this mailbox
	*/
	@Override
	public void setMailboxId(long mailboxId) {
		_mailbox.setMailboxId(mailboxId);
	}

	/**
	* Returns the group ID of this mailbox.
	*
	* @return the group ID of this mailbox
	*/
	@Override
	public long getGroupId() {
		return _mailbox.getGroupId();
	}

	/**
	* Sets the group ID of this mailbox.
	*
	* @param groupId the group ID of this mailbox
	*/
	@Override
	public void setGroupId(long groupId) {
		_mailbox.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this mailbox.
	*
	* @return the company ID of this mailbox
	*/
	@Override
	public long getCompanyId() {
		return _mailbox.getCompanyId();
	}

	/**
	* Sets the company ID of this mailbox.
	*
	* @param companyId the company ID of this mailbox
	*/
	@Override
	public void setCompanyId(long companyId) {
		_mailbox.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this mailbox.
	*
	* @return the user ID of this mailbox
	*/
	@Override
	public long getUserId() {
		return _mailbox.getUserId();
	}

	/**
	* Sets the user ID of this mailbox.
	*
	* @param userId the user ID of this mailbox
	*/
	@Override
	public void setUserId(long userId) {
		_mailbox.setUserId(userId);
	}

	/**
	* Returns the user uuid of this mailbox.
	*
	* @return the user uuid of this mailbox
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailbox.getUserUuid();
	}

	/**
	* Sets the user uuid of this mailbox.
	*
	* @param userUuid the user uuid of this mailbox
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_mailbox.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this mailbox.
	*
	* @return the user name of this mailbox
	*/
	@Override
	public java.lang.String getUserName() {
		return _mailbox.getUserName();
	}

	/**
	* Sets the user name of this mailbox.
	*
	* @param userName the user name of this mailbox
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_mailbox.setUserName(userName);
	}

	/**
	* Returns the create date of this mailbox.
	*
	* @return the create date of this mailbox
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _mailbox.getCreateDate();
	}

	/**
	* Sets the create date of this mailbox.
	*
	* @param createDate the create date of this mailbox
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_mailbox.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this mailbox.
	*
	* @return the modified date of this mailbox
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _mailbox.getModifiedDate();
	}

	/**
	* Sets the modified date of this mailbox.
	*
	* @param modifiedDate the modified date of this mailbox
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_mailbox.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the description of this mailbox.
	*
	* @return the description of this mailbox
	*/
	@Override
	public java.lang.String getDescription() {
		return _mailbox.getDescription();
	}

	/**
	* Sets the description of this mailbox.
	*
	* @param description the description of this mailbox
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_mailbox.setDescription(description);
	}

	/**
	* Returns the host of this mailbox.
	*
	* @return the host of this mailbox
	*/
	@Override
	public java.lang.String getHost() {
		return _mailbox.getHost();
	}

	/**
	* Sets the host of this mailbox.
	*
	* @param host the host of this mailbox
	*/
	@Override
	public void setHost(java.lang.String host) {
		_mailbox.setHost(host);
	}

	/**
	* Returns the port of this mailbox.
	*
	* @return the port of this mailbox
	*/
	@Override
	public int getPort() {
		return _mailbox.getPort();
	}

	/**
	* Sets the port of this mailbox.
	*
	* @param port the port of this mailbox
	*/
	@Override
	public void setPort(int port) {
		_mailbox.setPort(port);
	}

	/**
	* Returns the mailbox user of this mailbox.
	*
	* @return the mailbox user of this mailbox
	*/
	@Override
	public java.lang.String getMailboxUser() {
		return _mailbox.getMailboxUser();
	}

	/**
	* Sets the mailbox user of this mailbox.
	*
	* @param mailboxUser the mailbox user of this mailbox
	*/
	@Override
	public void setMailboxUser(java.lang.String mailboxUser) {
		_mailbox.setMailboxUser(mailboxUser);
	}

	/**
	* Returns the mailbox user secret of this mailbox.
	*
	* @return the mailbox user secret of this mailbox
	*/
	@Override
	public java.lang.String getMailboxUserSecret() {
		return _mailbox.getMailboxUserSecret();
	}

	/**
	* Sets the mailbox user secret of this mailbox.
	*
	* @param mailboxUserSecret the mailbox user secret of this mailbox
	*/
	@Override
	public void setMailboxUserSecret(java.lang.String mailboxUserSecret) {
		_mailbox.setMailboxUserSecret(mailboxUserSecret);
	}

	@Override
	public boolean isNew() {
		return _mailbox.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_mailbox.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _mailbox.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_mailbox.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _mailbox.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _mailbox.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_mailbox.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _mailbox.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_mailbox.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_mailbox.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_mailbox.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MailboxWrapper((Mailbox)_mailbox.clone());
	}

	@Override
	public int compareTo(at.mailbox.sync.model.Mailbox mailbox) {
		return _mailbox.compareTo(mailbox);
	}

	@Override
	public int hashCode() {
		return _mailbox.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.mailbox.sync.model.Mailbox> toCacheModel() {
		return _mailbox.toCacheModel();
	}

	@Override
	public at.mailbox.sync.model.Mailbox toEscapedModel() {
		return new MailboxWrapper(_mailbox.toEscapedModel());
	}

	@Override
	public at.mailbox.sync.model.Mailbox toUnescapedModel() {
		return new MailboxWrapper(_mailbox.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _mailbox.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _mailbox.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_mailbox.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MailboxWrapper)) {
			return false;
		}

		MailboxWrapper mailboxWrapper = (MailboxWrapper)obj;

		if (Validator.equals(_mailbox, mailboxWrapper._mailbox)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Mailbox getWrappedMailbox() {
		return _mailbox;
	}

	@Override
	public Mailbox getWrappedModel() {
		return _mailbox;
	}

	@Override
	public void resetOriginalValues() {
		_mailbox.resetOriginalValues();
	}

	private Mailbox _mailbox;
}