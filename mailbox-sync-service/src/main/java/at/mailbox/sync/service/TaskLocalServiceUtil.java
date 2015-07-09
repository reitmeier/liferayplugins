package at.mailbox.sync.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Task. This utility wraps
 * {@link at.mailbox.sync.service.impl.TaskLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Claus Reitmeier
 * @see TaskLocalService
 * @see at.mailbox.sync.service.base.TaskLocalServiceBaseImpl
 * @see at.mailbox.sync.service.impl.TaskLocalServiceImpl
 * @generated
 */
public class TaskLocalServiceUtil {
    private static TaskLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link at.mailbox.sync.service.impl.TaskLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the task to the database. Also notifies the appropriate model listeners.
    *
    * @param task the task
    * @return the task that was added
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Task addTask(
        at.mailbox.sync.model.Task task)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addTask(task);
    }

    /**
    * Creates a new task with the primary key. Does not add the task to the database.
    *
    * @param taskId the primary key for the new task
    * @return the new task
    */
    public static at.mailbox.sync.model.Task createTask(long taskId) {
        return getService().createTask(taskId);
    }

    /**
    * Deletes the task with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param taskId the primary key of the task
    * @return the task that was removed
    * @throws PortalException if a task with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Task deleteTask(long taskId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteTask(taskId);
    }

    /**
    * Deletes the task from the database. Also notifies the appropriate model listeners.
    *
    * @param task the task
    * @return the task that was removed
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Task deleteTask(
        at.mailbox.sync.model.Task task)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteTask(task);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static at.mailbox.sync.model.Task fetchTask(long taskId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchTask(taskId);
    }

    /**
    * Returns the task with the primary key.
    *
    * @param taskId the primary key of the task
    * @return the task
    * @throws PortalException if a task with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Task getTask(long taskId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getTask(taskId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the tasks.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of tasks
    * @param end the upper bound of the range of tasks (not inclusive)
    * @return the range of tasks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<at.mailbox.sync.model.Task> getTasks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTasks(start, end);
    }

    /**
    * Returns the number of tasks.
    *
    * @return the number of tasks
    * @throws SystemException if a system exception occurred
    */
    public static int getTasksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTasksCount();
    }

    /**
    * Updates the task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param task the task
    * @return the task that was updated
    * @throws SystemException if a system exception occurred
    */
    public static at.mailbox.sync.model.Task updateTask(
        at.mailbox.sync.model.Task task)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateTask(task);
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

    public static at.mailbox.sync.model.Task addTask() {
        return getService().addTask();
    }

    public static at.mailbox.sync.model.Task addTask(long userId, long groupId,
        java.lang.String description, java.lang.Long mailboxId,
        java.lang.Long permissionUserGroupId, java.lang.Long eventCalendarId,
        java.lang.Long documentFolderId, java.lang.Long webcontentFolderId,
        java.lang.Long vocabularyId, java.lang.Long period,
        java.lang.String clamavServerIP, java.lang.Integer clamavPort,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addTask(userId, groupId, description, mailboxId,
            permissionUserGroupId, eventCalendarId, documentFolderId,
            webcontentFolderId, vocabularyId, period, clamavServerIP,
            clamavPort, serviceContext);
    }

    public static java.util.List<at.mailbox.sync.model.Task> getTaskByMailboxId(
        long mailboxId, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTaskByMailboxId(mailboxId, status);
    }

    public static at.mailbox.sync.model.Task updateTask(long userId,
        long taskId, java.lang.String status, java.lang.String description,
        java.lang.Long mailboxId, java.lang.Long permissionUserGroupId,
        java.lang.Long eventCalendarId, java.lang.Long documentFolderId,
        java.lang.Long webcontentFolderId, java.lang.Long vocabularyId,
        java.lang.Long period, java.lang.String clamavServerIP,
        java.lang.Integer clamavPort,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateTask(userId, taskId, status, description, mailboxId,
            permissionUserGroupId, eventCalendarId, documentFolderId,
            webcontentFolderId, vocabularyId, period, clamavServerIP,
            clamavPort, serviceContext);
    }

    public static java.util.List<at.mailbox.sync.model.Task> getTaskByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTaskByGroupId(groupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static TaskLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    TaskLocalService.class.getName());

            if (invokableLocalService instanceof TaskLocalService) {
                _service = (TaskLocalService) invokableLocalService;
            } else {
                _service = new TaskLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(TaskLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(TaskLocalService service) {
    }
}
