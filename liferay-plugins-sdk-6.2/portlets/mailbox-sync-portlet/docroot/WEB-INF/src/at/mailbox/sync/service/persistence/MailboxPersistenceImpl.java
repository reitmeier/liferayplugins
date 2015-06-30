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

import at.mailbox.sync.NoSuchMailboxException;
import at.mailbox.sync.model.Mailbox;
import at.mailbox.sync.model.impl.MailboxImpl;
import at.mailbox.sync.model.impl.MailboxModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the mailbox service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Claus Reitmeier
 * @see MailboxPersistence
 * @see MailboxUtil
 * @generated
 */
public class MailboxPersistenceImpl extends BasePersistenceImpl<Mailbox>
	implements MailboxPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MailboxUtil} to access the mailbox persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MailboxImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxModelImpl.FINDER_CACHE_ENABLED, MailboxImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxModelImpl.FINDER_CACHE_ENABLED, MailboxImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxModelImpl.FINDER_CACHE_ENABLED, MailboxImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxModelImpl.FINDER_CACHE_ENABLED, MailboxImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			MailboxModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the mailboxs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching mailboxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Mailbox> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Mailbox> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<Mailbox> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Mailbox> list = (List<Mailbox>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Mailbox mailbox : list) {
				if ((groupId != mailbox.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MAILBOX_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MailboxModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Mailbox>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Mailbox>(list);
				}
				else {
					list = (List<Mailbox>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first mailbox in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mailbox
	 * @throws at.mailbox.sync.NoSuchMailboxException if a matching mailbox could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMailboxException, SystemException {
		Mailbox mailbox = fetchByGroupId_First(groupId, orderByComparator);

		if (mailbox != null) {
			return mailbox;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMailboxException(msg.toString());
	}

	/**
	 * Returns the first mailbox in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mailbox, or <code>null</code> if a matching mailbox could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Mailbox> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last mailbox in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mailbox
	 * @throws at.mailbox.sync.NoSuchMailboxException if a matching mailbox could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMailboxException, SystemException {
		Mailbox mailbox = fetchByGroupId_Last(groupId, orderByComparator);

		if (mailbox != null) {
			return mailbox;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMailboxException(msg.toString());
	}

	/**
	 * Returns the last mailbox in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mailbox, or <code>null</code> if a matching mailbox could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Mailbox> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Mailbox[] findByGroupId_PrevAndNext(long mailboxId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMailboxException, SystemException {
		Mailbox mailbox = findByPrimaryKey(mailboxId);

		Session session = null;

		try {
			session = openSession();

			Mailbox[] array = new MailboxImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, mailbox, groupId,
					orderByComparator, true);

			array[1] = mailbox;

			array[2] = getByGroupId_PrevAndNext(session, mailbox, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Mailbox getByGroupId_PrevAndNext(Session session,
		Mailbox mailbox, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MAILBOX_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MailboxModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(mailbox);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Mailbox> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the mailboxs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Mailbox mailbox : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(mailbox);
		}
	}

	/**
	 * Returns the number of mailboxs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching mailboxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MAILBOX_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "mailbox.groupId = ?";

	public MailboxPersistenceImpl() {
		setModelClass(Mailbox.class);
	}

	/**
	 * Caches the mailbox in the entity cache if it is enabled.
	 *
	 * @param mailbox the mailbox
	 */
	@Override
	public void cacheResult(Mailbox mailbox) {
		EntityCacheUtil.putResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxImpl.class, mailbox.getPrimaryKey(), mailbox);

		mailbox.resetOriginalValues();
	}

	/**
	 * Caches the mailboxs in the entity cache if it is enabled.
	 *
	 * @param mailboxs the mailboxs
	 */
	@Override
	public void cacheResult(List<Mailbox> mailboxs) {
		for (Mailbox mailbox : mailboxs) {
			if (EntityCacheUtil.getResult(
						MailboxModelImpl.ENTITY_CACHE_ENABLED,
						MailboxImpl.class, mailbox.getPrimaryKey()) == null) {
				cacheResult(mailbox);
			}
			else {
				mailbox.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all mailboxs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MailboxImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MailboxImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mailbox.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Mailbox mailbox) {
		EntityCacheUtil.removeResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxImpl.class, mailbox.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Mailbox> mailboxs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Mailbox mailbox : mailboxs) {
			EntityCacheUtil.removeResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
				MailboxImpl.class, mailbox.getPrimaryKey());
		}
	}

	/**
	 * Creates a new mailbox with the primary key. Does not add the mailbox to the database.
	 *
	 * @param mailboxId the primary key for the new mailbox
	 * @return the new mailbox
	 */
	@Override
	public Mailbox create(long mailboxId) {
		Mailbox mailbox = new MailboxImpl();

		mailbox.setNew(true);
		mailbox.setPrimaryKey(mailboxId);

		return mailbox;
	}

	/**
	 * Removes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailboxId the primary key of the mailbox
	 * @return the mailbox that was removed
	 * @throws at.mailbox.sync.NoSuchMailboxException if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox remove(long mailboxId)
		throws NoSuchMailboxException, SystemException {
		return remove((Serializable)mailboxId);
	}

	/**
	 * Removes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mailbox
	 * @return the mailbox that was removed
	 * @throws at.mailbox.sync.NoSuchMailboxException if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox remove(Serializable primaryKey)
		throws NoSuchMailboxException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Mailbox mailbox = (Mailbox)session.get(MailboxImpl.class, primaryKey);

			if (mailbox == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMailboxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(mailbox);
		}
		catch (NoSuchMailboxException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Mailbox removeImpl(Mailbox mailbox) throws SystemException {
		mailbox = toUnwrappedModel(mailbox);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mailbox)) {
				mailbox = (Mailbox)session.get(MailboxImpl.class,
						mailbox.getPrimaryKeyObj());
			}

			if (mailbox != null) {
				session.delete(mailbox);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (mailbox != null) {
			clearCache(mailbox);
		}

		return mailbox;
	}

	@Override
	public Mailbox updateImpl(at.mailbox.sync.model.Mailbox mailbox)
		throws SystemException {
		mailbox = toUnwrappedModel(mailbox);

		boolean isNew = mailbox.isNew();

		MailboxModelImpl mailboxModelImpl = (MailboxModelImpl)mailbox;

		Session session = null;

		try {
			session = openSession();

			if (mailbox.isNew()) {
				session.save(mailbox);

				mailbox.setNew(false);
			}
			else {
				session.merge(mailbox);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MailboxModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((mailboxModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						mailboxModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { mailboxModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
			MailboxImpl.class, mailbox.getPrimaryKey(), mailbox);

		return mailbox;
	}

	protected Mailbox toUnwrappedModel(Mailbox mailbox) {
		if (mailbox instanceof MailboxImpl) {
			return mailbox;
		}

		MailboxImpl mailboxImpl = new MailboxImpl();

		mailboxImpl.setNew(mailbox.isNew());
		mailboxImpl.setPrimaryKey(mailbox.getPrimaryKey());

		mailboxImpl.setMailboxId(mailbox.getMailboxId());
		mailboxImpl.setGroupId(mailbox.getGroupId());
		mailboxImpl.setCompanyId(mailbox.getCompanyId());
		mailboxImpl.setUserId(mailbox.getUserId());
		mailboxImpl.setUserName(mailbox.getUserName());
		mailboxImpl.setCreateDate(mailbox.getCreateDate());
		mailboxImpl.setModifiedDate(mailbox.getModifiedDate());
		mailboxImpl.setDescription(mailbox.getDescription());
		mailboxImpl.setHost(mailbox.getHost());
		mailboxImpl.setPort(mailbox.getPort());
		mailboxImpl.setMailboxUser(mailbox.getMailboxUser());
		mailboxImpl.setMailboxUserSecret(mailbox.getMailboxUserSecret());

		return mailboxImpl;
	}

	/**
	 * Returns the mailbox with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the mailbox
	 * @return the mailbox
	 * @throws at.mailbox.sync.NoSuchMailboxException if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMailboxException, SystemException {
		Mailbox mailbox = fetchByPrimaryKey(primaryKey);

		if (mailbox == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMailboxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return mailbox;
	}

	/**
	 * Returns the mailbox with the primary key or throws a {@link at.mailbox.sync.NoSuchMailboxException} if it could not be found.
	 *
	 * @param mailboxId the primary key of the mailbox
	 * @return the mailbox
	 * @throws at.mailbox.sync.NoSuchMailboxException if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox findByPrimaryKey(long mailboxId)
		throws NoSuchMailboxException, SystemException {
		return findByPrimaryKey((Serializable)mailboxId);
	}

	/**
	 * Returns the mailbox with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mailbox
	 * @return the mailbox, or <code>null</code> if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Mailbox mailbox = (Mailbox)EntityCacheUtil.getResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
				MailboxImpl.class, primaryKey);

		if (mailbox == _nullMailbox) {
			return null;
		}

		if (mailbox == null) {
			Session session = null;

			try {
				session = openSession();

				mailbox = (Mailbox)session.get(MailboxImpl.class, primaryKey);

				if (mailbox != null) {
					cacheResult(mailbox);
				}
				else {
					EntityCacheUtil.putResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
						MailboxImpl.class, primaryKey, _nullMailbox);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MailboxModelImpl.ENTITY_CACHE_ENABLED,
					MailboxImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return mailbox;
	}

	/**
	 * Returns the mailbox with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mailboxId the primary key of the mailbox
	 * @return the mailbox, or <code>null</code> if a mailbox with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mailbox fetchByPrimaryKey(long mailboxId) throws SystemException {
		return fetchByPrimaryKey((Serializable)mailboxId);
	}

	/**
	 * Returns all the mailboxs.
	 *
	 * @return the mailboxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Mailbox> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Mailbox> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Mailbox> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Mailbox> list = (List<Mailbox>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MAILBOX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MAILBOX;

				if (pagination) {
					sql = sql.concat(MailboxModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Mailbox>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Mailbox>(list);
				}
				else {
					list = (List<Mailbox>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the mailboxs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Mailbox mailbox : findAll()) {
			remove(mailbox);
		}
	}

	/**
	 * Returns the number of mailboxs.
	 *
	 * @return the number of mailboxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MAILBOX);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the mailbox persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.mailbox.sync.model.Mailbox")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Mailbox>> listenersList = new ArrayList<ModelListener<Mailbox>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Mailbox>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MailboxImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MAILBOX = "SELECT mailbox FROM Mailbox mailbox";
	private static final String _SQL_SELECT_MAILBOX_WHERE = "SELECT mailbox FROM Mailbox mailbox WHERE ";
	private static final String _SQL_COUNT_MAILBOX = "SELECT COUNT(mailbox) FROM Mailbox mailbox";
	private static final String _SQL_COUNT_MAILBOX_WHERE = "SELECT COUNT(mailbox) FROM Mailbox mailbox WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "mailbox.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Mailbox exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Mailbox exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MailboxPersistenceImpl.class);
	private static Mailbox _nullMailbox = new MailboxImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Mailbox> toCacheModel() {
				return _nullMailboxCacheModel;
			}
		};

	private static CacheModel<Mailbox> _nullMailboxCacheModel = new CacheModel<Mailbox>() {
			@Override
			public Mailbox toEntityModel() {
				return _nullMailbox;
			}
		};
}