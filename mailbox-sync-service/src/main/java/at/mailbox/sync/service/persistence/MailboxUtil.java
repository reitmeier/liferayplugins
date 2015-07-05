package at.mailbox.sync.service.persistence;

import at.mailbox.sync.model.Mailbox;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the mailbox service. This utility wraps {@link MailboxPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Claus Reitmeier
 * @see MailboxPersistence
 * @see MailboxPersistenceImpl
 * @generated
 */
public class MailboxUtil {
    private static MailboxPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Mailbox mailbox) {
        getPersistence().clearCache(mailbox);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Mailbox> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Mailbox> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Mailbox> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Mailbox update(Mailbox mailbox) throws SystemException {
        return getPersistence().update(mailbox);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Mailbox update(Mailbox mailbox, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(mailbox, serviceContext);
    }

    /**
    * Returns all the mailboxs where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching mailboxs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<at.mailbox.sync.model.Mailbox> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
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
    public static java.util.List<at.mailbox.sync.model.Mailbox> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
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
    public static java.util.List<at.mailbox.sync.model.Mailbox> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
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
    public static at.mailbox.sync.model.Mailbox findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws at.mailbox.sync.NoSuchMailboxException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first mailbox in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching mailbox, or <code>null</code> if a matching mailbox could not be found
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Mailbox fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
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
    public static at.mailbox.sync.model.Mailbox findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws at.mailbox.sync.NoSuchMailboxException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last mailbox in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching mailbox, or <code>null</code> if a matching mailbox could not be found
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Mailbox fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
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
    public static at.mailbox.sync.model.Mailbox[] findByGroupId_PrevAndNext(
        long mailboxId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws at.mailbox.sync.NoSuchMailboxException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(mailboxId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the mailboxs where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of mailboxs where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching mailboxs
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Caches the mailbox in the entity cache if it is enabled.
    *
    * @param mailbox the mailbox
    */
    public static void cacheResult(at.mailbox.sync.model.Mailbox mailbox) {
        getPersistence().cacheResult(mailbox);
    }

    /**
    * Caches the mailboxs in the entity cache if it is enabled.
    *
    * @param mailboxs the mailboxs
    */
    public static void cacheResult(
        java.util.List<at.mailbox.sync.model.Mailbox> mailboxs) {
        getPersistence().cacheResult(mailboxs);
    }

    /**
    * Creates a new mailbox with the primary key. Does not add the mailbox to the database.
    *
    * @param mailboxId the primary key for the new mailbox
    * @return the new mailbox
    */
    public static at.mailbox.sync.model.Mailbox create(long mailboxId) {
        return getPersistence().create(mailboxId);
    }

    /**
    * Removes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailboxId the primary key of the mailbox
    * @return the mailbox that was removed
    * @throws at.mailbox.sync.NoSuchMailboxException if a mailbox with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Mailbox remove(long mailboxId)
        throws at.mailbox.sync.NoSuchMailboxException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(mailboxId);
    }

    public static at.mailbox.sync.model.Mailbox updateImpl(
        at.mailbox.sync.model.Mailbox mailbox)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(mailbox);
    }

    /**
    * Returns the mailbox with the primary key or throws a {@link at.mailbox.sync.NoSuchMailboxException} if it could not be found.
    *
    * @param mailboxId the primary key of the mailbox
    * @return the mailbox
    * @throws at.mailbox.sync.NoSuchMailboxException if a mailbox with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Mailbox findByPrimaryKey(long mailboxId)
        throws at.mailbox.sync.NoSuchMailboxException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(mailboxId);
    }

    /**
    * Returns the mailbox with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param mailboxId the primary key of the mailbox
    * @return the mailbox, or <code>null</code> if a mailbox with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Mailbox fetchByPrimaryKey(
        long mailboxId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(mailboxId);
    }

    /**
    * Returns all the mailboxs.
    *
    * @return the mailboxs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<at.mailbox.sync.model.Mailbox> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<at.mailbox.sync.model.Mailbox> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<at.mailbox.sync.model.Mailbox> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the mailboxs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of mailboxs.
    *
    * @return the number of mailboxs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static MailboxPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (MailboxPersistence) PortletBeanLocatorUtil.locate(at.mailbox.sync.service.ClpSerializer.getServletContextName(),
                    MailboxPersistence.class.getName());

            ReferenceRegistry.registerReference(MailboxUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(MailboxPersistence persistence) {
    }
}
