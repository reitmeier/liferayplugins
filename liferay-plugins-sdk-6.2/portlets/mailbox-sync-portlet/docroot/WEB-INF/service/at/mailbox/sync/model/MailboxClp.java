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

import at.mailbox.sync.service.ClpSerializer;
import at.mailbox.sync.service.MailboxLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Claus Reitmeier
 */
public class MailboxClp extends BaseModelImpl<Mailbox> implements Mailbox {
	public MailboxClp() {
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
	public long getPrimaryKey() {
		return _mailboxId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMailboxId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mailboxId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getMailboxId() {
		return _mailboxId;
	}

	@Override
	public void setMailboxId(long mailboxId) {
		_mailboxId = mailboxId;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setMailboxId", long.class);

				method.invoke(_mailboxRemoteModel, mailboxId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_mailboxRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_mailboxRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_mailboxRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_mailboxRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_mailboxRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_mailboxRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_mailboxRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHost() {
		return _host;
	}

	@Override
	public void setHost(String host) {
		_host = host;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setHost", String.class);

				method.invoke(_mailboxRemoteModel, host);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPort() {
		return _port;
	}

	@Override
	public void setPort(int port) {
		_port = port;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setPort", int.class);

				method.invoke(_mailboxRemoteModel, port);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMailboxUser() {
		return _mailboxUser;
	}

	@Override
	public void setMailboxUser(String mailboxUser) {
		_mailboxUser = mailboxUser;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setMailboxUser", String.class);

				method.invoke(_mailboxRemoteModel, mailboxUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMailboxUserSecret() {
		return _mailboxUserSecret;
	}

	@Override
	public void setMailboxUserSecret(String mailboxUserSecret) {
		_mailboxUserSecret = mailboxUserSecret;

		if (_mailboxRemoteModel != null) {
			try {
				Class<?> clazz = _mailboxRemoteModel.getClass();

				Method method = clazz.getMethod("setMailboxUserSecret",
						String.class);

				method.invoke(_mailboxRemoteModel, mailboxUserSecret);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMailboxRemoteModel() {
		return _mailboxRemoteModel;
	}

	public void setMailboxRemoteModel(BaseModel<?> mailboxRemoteModel) {
		_mailboxRemoteModel = mailboxRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _mailboxRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_mailboxRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MailboxLocalServiceUtil.addMailbox(this);
		}
		else {
			MailboxLocalServiceUtil.updateMailbox(this);
		}
	}

	@Override
	public Mailbox toEscapedModel() {
		return (Mailbox)ProxyUtil.newProxyInstance(Mailbox.class.getClassLoader(),
			new Class[] { Mailbox.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MailboxClp clone = new MailboxClp();

		clone.setMailboxId(getMailboxId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDescription(getDescription());
		clone.setHost(getHost());
		clone.setPort(getPort());
		clone.setMailboxUser(getMailboxUser());
		clone.setMailboxUserSecret(getMailboxUserSecret());

		return clone;
	}

	@Override
	public int compareTo(Mailbox mailbox) {
		long primaryKey = mailbox.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MailboxClp)) {
			return false;
		}

		MailboxClp mailbox = (MailboxClp)obj;

		long primaryKey = mailbox.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{mailboxId=");
		sb.append(getMailboxId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", host=");
		sb.append(getHost());
		sb.append(", port=");
		sb.append(getPort());
		sb.append(", mailboxUser=");
		sb.append(getMailboxUser());
		sb.append(", mailboxUserSecret=");
		sb.append(getMailboxUserSecret());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("at.mailbox.sync.model.Mailbox");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mailboxId</column-name><column-value><![CDATA[");
		sb.append(getMailboxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>host</column-name><column-value><![CDATA[");
		sb.append(getHost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>port</column-name><column-value><![CDATA[");
		sb.append(getPort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mailboxUser</column-name><column-value><![CDATA[");
		sb.append(getMailboxUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mailboxUserSecret</column-name><column-value><![CDATA[");
		sb.append(getMailboxUserSecret());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _mailboxId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private String _host;
	private int _port;
	private String _mailboxUser;
	private String _mailboxUserSecret;
	private BaseModel<?> _mailboxRemoteModel;
	private Class<?> _clpSerializerClass = at.mailbox.sync.service.ClpSerializer.class;
}