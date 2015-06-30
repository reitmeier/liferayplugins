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

package at.mailbox.sync.service.persistence;

import at.mailbox.sync.model.Mailbox;
import at.mailbox.sync.service.MailboxLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Claus Reitmeier
 * @generated
 */
public abstract class MailboxActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public MailboxActionableDynamicQuery() throws SystemException {
		setBaseLocalService(MailboxLocalServiceUtil.getService());
		setClass(Mailbox.class);

		setClassLoader(at.mailbox.sync.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("mailboxId");
	}
}