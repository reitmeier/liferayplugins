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

package at.mailbox.sync.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MailboxLocalService}.
 *
 * @author Claus Reitmeier
 * @see MailboxLocalService
 * @generated
 */
public class MailboxLocalServiceWrapper implements MailboxLocalService,
	ServiceWrapper<MailboxLocalService> {
	public MailboxLocalServiceWrapper(MailboxLocalService mailboxLocalService) {
		_mailboxLocalService = mailboxLocalService;
	}

	/**
	* Adds the mailbox to the database. Also notifies the appropriate model listeners.
	*
	* @param mailbox the mailbox
	* @return the mailbox that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.mailbox.sync.model.Mailbox addMailbox(
		at.mailbox.sync.model.Mailbox mailbox)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.addMailbox(mailbox);
	}

	/**
	* Creates a new mailbox with the primary key. Does not add the mailbox to the database.
	*
	* @param mailboxId the primary key for the new mailbox
	* @return the new mailbox
	*/
	@Override
	public at.mailbox.sync.model.Mailbox createMailbox(long mailboxId) {
		return _mailboxLocalService.createMailbox(mailboxId);
	}

	/**
	* Deletes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox that was removed
	* @throws PortalException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.mailbox.sync.model.Mailbox deleteMailbox(long mailboxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.deleteMailbox(mailboxId);
	}

	/**
	* Deletes the mailbox from the database. Also notifies the appropriate model listeners.
	*
	* @param mailbox the mailbox
	* @return the mailbox that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.mailbox.sync.model.Mailbox deleteMailbox(
		at.mailbox.sync.model.Mailbox mailbox)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.deleteMailbox(mailbox);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mailboxLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.MailboxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.MailboxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public at.mailbox.sync.model.Mailbox fetchMailbox(long mailboxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.fetchMailbox(mailboxId);
	}

	/**
	* Returns the mailbox with the primary key.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox
	* @throws PortalException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.mailbox.sync.model.Mailbox getMailbox(long mailboxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.getMailbox(mailboxId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the mailboxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.MailboxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mailboxs
	* @param end the upper bound of the range of mailboxs (not inclusive)
	* @return the range of mailboxs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.mailbox.sync.model.Mailbox> getMailboxs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.getMailboxs(start, end);
	}

	/**
	* Returns the number of mailboxs.
	*
	* @return the number of mailboxs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMailboxsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.getMailboxsCount();
	}

	/**
	* Updates the mailbox in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param mailbox the mailbox
	* @return the mailbox that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.mailbox.sync.model.Mailbox updateMailbox(
		at.mailbox.sync.model.Mailbox mailbox)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.updateMailbox(mailbox);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _mailboxLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_mailboxLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _mailboxLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public at.mailbox.sync.model.Mailbox addMailbox(long userId, long groupId,
		java.lang.String description, java.lang.String host, int port,
		java.lang.String mailboxUser, java.lang.String mailboxUserSecret,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.addMailbox(userId, groupId, description,
			host, port, mailboxUser, mailboxUserSecret, serviceContext);
	}

	@Override
	public at.mailbox.sync.model.Mailbox getMaibox(long mailboxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.getMaibox(mailboxId);
	}

	@Override
	public java.util.List<at.mailbox.sync.model.Mailbox> getMailboxByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.getMailboxByGroupId(groupId);
	}

	@Override
	public int getMailboxCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.getMailboxCountByGroupId(groupId);
	}

	@Override
	public at.mailbox.sync.model.Mailbox updateMailbox(long userId,
		long mailboxId, java.lang.String description, java.lang.String host,
		int port, java.lang.String mailboxUser,
		java.lang.String mailboxUserSecret,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mailboxLocalService.updateMailbox(userId, mailboxId,
			description, host, port, mailboxUser, mailboxUserSecret,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MailboxLocalService getWrappedMailboxLocalService() {
		return _mailboxLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMailboxLocalService(
		MailboxLocalService mailboxLocalService) {
		_mailboxLocalService = mailboxLocalService;
	}

	@Override
	public MailboxLocalService getWrappedService() {
		return _mailboxLocalService;
	}

	@Override
	public void setWrappedService(MailboxLocalService mailboxLocalService) {
		_mailboxLocalService = mailboxLocalService;
	}

	private MailboxLocalService _mailboxLocalService;
}