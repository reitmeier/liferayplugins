package at.mailbox.sync.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Mailbox. This utility wraps
 * {@link at.mailbox.sync.service.impl.MailboxLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Claus Reitmeier
 * @see MailboxLocalService
 * @see at.mailbox.sync.service.base.MailboxLocalServiceBaseImpl
 * @see at.mailbox.sync.service.impl.MailboxLocalServiceImpl
 * @generated
 */
public class MailboxLocalServiceUtil {
    private static MailboxLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link at.mailbox.sync.service.impl.MailboxLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the mailbox to the database. Also notifies the appropriate model listeners.
    *
    * @param mailbox the mailbox
    * @return the mailbox that was added
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Mailbox addMailbox(
        at.mailbox.sync.model.Mailbox mailbox)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addMailbox(mailbox);
    }

    /**
    * Creates a new mailbox with the primary key. Does not add the mailbox to the database.
    *
    * @param mailboxId the primary key for the new mailbox
    * @return the new mailbox
    */
    public static at.mailbox.sync.model.Mailbox createMailbox(long mailboxId) {
        return getService().createMailbox(mailboxId);
    }

    /**
    * Deletes the mailbox with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailboxId the primary key of the mailbox
    * @return the mailbox that was removed
    * @throws PortalException if a mailbox with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Mailbox deleteMailbox(long mailboxId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteMailbox(mailboxId);
    }

    /**
    * Deletes the mailbox from the database. Also notifies the appropriate model listeners.
    *
    * @param mailbox the mailbox
    * @return the mailbox that was removed
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Mailbox deleteMailbox(
        at.mailbox.sync.model.Mailbox mailbox)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteMailbox(mailbox);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static at.mailbox.sync.model.Mailbox fetchMailbox(long mailboxId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchMailbox(mailboxId);
    }

    /**
    * Returns the mailbox with the primary key.
    *
    * @param mailboxId the primary key of the mailbox
    * @return the mailbox
    * @throws PortalException if a mailbox with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Mailbox getMailbox(long mailboxId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailbox(mailboxId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<at.mailbox.sync.model.Mailbox> getMailboxs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailboxs(start, end);
    }

    /**
    * Returns the number of mailboxs.
    *
    * @return the number of mailboxs
    * @throws SystemException if a system exception occurred
    */
    public static int getMailboxsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailboxsCount();
    }

    /**
    * Updates the mailbox in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param mailbox the mailbox
    * @return the mailbox that was updated
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Mailbox updateMailbox(
        at.mailbox.sync.model.Mailbox mailbox)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateMailbox(mailbox);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static at.mailbox.sync.model.Mailbox addMailbox(long userId,
        long groupId, java.lang.String description, java.lang.String host,
        int port, java.lang.String mailboxUser,
        java.lang.String mailboxUserSecret,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addMailbox(userId, groupId, description, host, port,
            mailboxUser, mailboxUserSecret, serviceContext);
    }

    public static at.mailbox.sync.model.Mailbox getMaibox(long mailboxId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getMaibox(mailboxId);
    }

    public static java.util.List<at.mailbox.sync.model.Mailbox> getMailboxByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailboxByGroupId(groupId);
    }

    public static int getMailboxCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMailboxCountByGroupId(groupId);
    }

    public static at.mailbox.sync.model.Mailbox updateMailbox(long userId,
        long mailboxId, java.lang.String description, java.lang.String host,
        int port, java.lang.String mailboxUser,
        java.lang.String mailboxUserSecret,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateMailbox(userId, mailboxId, description, host, port,
            mailboxUser, mailboxUserSecret, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static MailboxLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MailboxLocalService.class.getName());

            if (invokableLocalService instanceof MailboxLocalService) {
                _service = (MailboxLocalService) invokableLocalService;
            } else {
                _service = new MailboxLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(MailboxLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MailboxLocalService service) {
    }
}
