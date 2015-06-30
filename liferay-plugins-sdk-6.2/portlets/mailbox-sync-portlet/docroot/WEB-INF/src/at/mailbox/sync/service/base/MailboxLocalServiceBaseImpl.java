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

package at.mailbox.sync.service.base;

import at.mailbox.sync.model.Mailbox;
import at.mailbox.sync.service.MailboxLocalService;
import at.mailbox.sync.service.persistence.MailboxPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the mailbox local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.mailbox.sync.service.impl.MailboxLocalServiceImpl}.
 * </p>
 *
 * @author Claus Reitmeier
 * @see at.mailbox.sync.service.impl.MailboxLocalServiceImpl
 * @see at.mailbox.sync.service.MailboxLocalServiceUtil
 * @generated
 */
public abstract class MailboxLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements MailboxLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.mailbox.sync.service.MailboxLocalServiceUtil} to access the mailbox local service.
	 */

	/**
	 * Adds the mailbox to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailbox the mailbox
	 * @return the mailbox that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Mailbox addMailbox(Mailbox mailbox) throws SystemException {
		mailbox.setNew(true);

		return mailboxPersistence.update(mailbox);
	}

	/**
	 * Creates a new mailbox with the primary key. Does not add the mailbox to the database.
	 *
	 * @param mailboxId the primary key for the new mailbox
	 * @return the new mailbox
	 */
	@Override
	public Mailbox createMailbox(long mailboxId) {
		return mailboxPersistence.create(mailboxId);
	}

	/**
	 * Deletes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailboxId the primary key of the mailbox
	 * @return the mailbox that was removed
	 * @throws PortalException if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Mailbox deleteMailbox(long mailboxId)
		throws PortalException, SystemException {
		return mailboxPersistence.remove(mailboxId);
	}

	/**
	 * Deletes the mailbox from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailbox the mailbox
	 * @return the mailbox that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Mailbox deleteMailbox(Mailbox mailbox) throws SystemException {
		return mailboxPersistence.remove(mailbox);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Mailbox.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return mailboxPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return mailboxPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return mailboxPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return mailboxPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return mailboxPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Mailbox fetchMailbox(long mailboxId) throws SystemException {
		return mailboxPersistence.fetchByPrimaryKey(mailboxId);
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
	public Mailbox getMailbox(long mailboxId)
		throws PortalException, SystemException {
		return mailboxPersistence.findByPrimaryKey(mailboxId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return mailboxPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Mailbox> getMailboxs(int start, int end)
		throws SystemException {
		return mailboxPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of mailboxs.
	 *
	 * @return the number of mailboxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getMailboxsCount() throws SystemException {
		return mailboxPersistence.countAll();
	}

	/**
	 * Updates the mailbox in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mailbox the mailbox
	 * @return the mailbox that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Mailbox updateMailbox(Mailbox mailbox) throws SystemException {
		return mailboxPersistence.update(mailbox);
	}

	/**
	 * Returns the mailbox local service.
	 *
	 * @return the mailbox local service
	 */
	public at.mailbox.sync.service.MailboxLocalService getMailboxLocalService() {
		return mailboxLocalService;
	}

	/**
	 * Sets the mailbox local service.
	 *
	 * @param mailboxLocalService the mailbox local service
	 */
	public void setMailboxLocalService(
		at.mailbox.sync.service.MailboxLocalService mailboxLocalService) {
		this.mailboxLocalService = mailboxLocalService;
	}

	/**
	 * Returns the mailbox remote service.
	 *
	 * @return the mailbox remote service
	 */
	public at.mailbox.sync.service.MailboxService getMailboxService() {
		return mailboxService;
	}

	/**
	 * Sets the mailbox remote service.
	 *
	 * @param mailboxService the mailbox remote service
	 */
	public void setMailboxService(
		at.mailbox.sync.service.MailboxService mailboxService) {
		this.mailboxService = mailboxService;
	}

	/**
	 * Returns the mailbox persistence.
	 *
	 * @return the mailbox persistence
	 */
	public MailboxPersistence getMailboxPersistence() {
		return mailboxPersistence;
	}

	/**
	 * Sets the mailbox persistence.
	 *
	 * @param mailboxPersistence the mailbox persistence
	 */
	public void setMailboxPersistence(MailboxPersistence mailboxPersistence) {
		this.mailboxPersistence = mailboxPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("at.mailbox.sync.model.Mailbox",
			mailboxLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"at.mailbox.sync.model.Mailbox");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Mailbox.class;
	}

	protected String getModelClassName() {
		return Mailbox.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = mailboxPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = at.mailbox.sync.service.MailboxLocalService.class)
	protected at.mailbox.sync.service.MailboxLocalService mailboxLocalService;
	@BeanReference(type = at.mailbox.sync.service.MailboxService.class)
	protected at.mailbox.sync.service.MailboxService mailboxService;
	@BeanReference(type = MailboxPersistence.class)
	protected MailboxPersistence mailboxPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private MailboxLocalServiceClpInvoker _clpInvoker = new MailboxLocalServiceClpInvoker();
}