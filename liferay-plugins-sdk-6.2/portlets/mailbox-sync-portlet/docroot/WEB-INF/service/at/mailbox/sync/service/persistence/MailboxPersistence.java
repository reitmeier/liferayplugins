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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the mailbox service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Claus Reitmeier
 * @see MailboxPersistenceImpl
 * @see MailboxUtil
 * @generated
 */
public interface MailboxPersistence extends BasePersistence<Mailbox> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MailboxUtil} to access the mailbox persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the mailboxs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.mailbox.sync.model.Mailbox> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the mailboxs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.MailboxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of mailboxs
	* @param end the upper bound of the range of mailboxs (not inclusive)
	* @return the range of matching mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.mailbox.sync.model.Mailbox> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the mailboxs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.MailboxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of mailboxs
	* @param end the upper bound of the range of mailboxs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.mailbox.sync.model.Mailbox> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first mailbox in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mailbox
	* @throws at.mailbox.sync.NoSuchMailboxException if a matching mailbox could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.mailbox.sync.model.Mailbox findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.mailbox.sync.NoSuchMailboxException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first mailbox in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mailbox, or <code>null</code> if a matching mailbox could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.mailbox.sync.model.Mailbox fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last mailbox in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mailbox
	* @throws at.mailbox.sync.NoSuchMailboxException if a matching mailbox could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.mailbox.sync.model.Mailbox findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.mailbox.sync.NoSuchMailboxException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last mailbox in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mailbox, or <code>null</code> if a matching mailbox could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.mailbox.sync.model.Mailbox fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the mailboxs before and after the current mailbox in the ordered set where groupId = &#63;.
	*
	* @param mailboxId the primary key of the current mailbox
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next mailbox
	* @throws at.mailbox.sync.NoSuchMailboxException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.mailbox.sync.model.Mailbox[] findByGroupId_PrevAndNext(
		long mailboxId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.mailbox.sync.NoSuchMailboxException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the mailboxs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of mailboxs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the mailbox in the entity cache if it is enabled.
	*
	* @param mailbox the mailbox
	*/
	public void cacheResult(at.mailbox.sync.model.Mailbox mailbox);

	/**
	* Caches the mailboxs in the entity cache if it is enabled.
	*
	* @param mailboxs the mailboxs
	*/
	public void cacheResult(
		java.util.List<at.mailbox.sync.model.Mailbox> mailboxs);

	/**
	* Creates a new mailbox with the primary key. Does not add the mailbox to the database.
	*
	* @param mailboxId the primary key for the new mailbox
	* @return the new mailbox
	*/
	public at.mailbox.sync.model.Mailbox create(long mailboxId);

	/**
	* Removes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox that was removed
	* @throws at.mailbox.sync.NoSuchMailboxException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.mailbox.sync.model.Mailbox remove(long mailboxId)
		throws at.mailbox.sync.NoSuchMailboxException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.mailbox.sync.model.Mailbox updateImpl(
		at.mailbox.sync.model.Mailbox mailbox)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the mailbox with the primary key or throws a {@link at.mailbox.sync.NoSuchMailboxException} if it could not be found.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox
	* @throws at.mailbox.sync.NoSuchMailboxException if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.mailbox.sync.model.Mailbox findByPrimaryKey(long mailboxId)
		throws at.mailbox.sync.NoSuchMailboxException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the mailbox with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mailboxId the primary key of the mailbox
	* @return the mailbox, or <code>null</code> if a mailbox with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.mailbox.sync.model.Mailbox fetchByPrimaryKey(long mailboxId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the mailboxs.
	*
	* @return the mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.mailbox.sync.model.Mailbox> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.mailbox.sync.model.Mailbox> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the mailboxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.MailboxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mailboxs
	* @param end the upper bound of the range of mailboxs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.mailbox.sync.model.Mailbox> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the mailboxs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of mailboxs.
	*
	* @return the number of mailboxs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}