package at.mailbox.sync.service.persistence;

import at.mailbox.sync.model.Task;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Claus Reitmeier
 * @see TaskPersistenceImpl
 * @see TaskUtil
 * @generated
 */
public interface TaskPersistence extends BasePersistence<Task> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link TaskUtil} to access the task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the tasks where mailboxId = &#63; and status = &#63;.
    *
    * @param mailboxId the mailbox ID
    * @param status the status
    * @return the matching tasks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<at.mailbox.sync.model.Task> findByMailboxId(
        long mailboxId, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the tasks where mailboxId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param mailboxId the mailbox ID
    * @param status the status
    * @param start the lower bound of the range of tasks
    * @param end the upper bound of the range of tasks (not inclusive)
    * @return the range of matching tasks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<at.mailbox.sync.model.Task> findByMailboxId(
        long mailboxId, java.lang.String status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the tasks where mailboxId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param mailboxId the mailbox ID
    * @param status the status
    * @param start the lower bound of the range of tasks
    * @param end the upper bound of the range of tasks (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching tasks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<at.mailbox.sync.model.Task> findByMailboxId(
        long mailboxId, java.lang.String status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first task in the ordered set where mailboxId = &#63; and status = &#63;.
    *
    * @param mailboxId the mailbox ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching task
    * @throws at.mailbox.sync.NoSuchTaskException if a matching task could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task findByMailboxId_First(long mailboxId,
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws at.mailbox.sync.NoSuchTaskException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first task in the ordered set where mailboxId = &#63; and status = &#63;.
    *
    * @param mailboxId the mailbox ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching task, or <code>null</code> if a matching task could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task fetchByMailboxId_First(long mailboxId,
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last task in the ordered set where mailboxId = &#63; and status = &#63;.
    *
    * @param mailboxId the mailbox ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching task
    * @throws at.mailbox.sync.NoSuchTaskException if a matching task could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task findByMailboxId_Last(long mailboxId,
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws at.mailbox.sync.NoSuchTaskException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last task in the ordered set where mailboxId = &#63; and status = &#63;.
    *
    * @param mailboxId the mailbox ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching task, or <code>null</code> if a matching task could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task fetchByMailboxId_Last(long mailboxId,
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the tasks before and after the current task in the ordered set where mailboxId = &#63; and status = &#63;.
    *
    * @param taskId the primary key of the current task
    * @param mailboxId the mailbox ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next task
    * @throws at.mailbox.sync.NoSuchTaskException if a task with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task[] findByMailboxId_PrevAndNext(
        long taskId, long mailboxId, java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws at.mailbox.sync.NoSuchTaskException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tasks where mailboxId = &#63; and status = &#63; from the database.
    *
    * @param mailboxId the mailbox ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByMailboxId(long mailboxId, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tasks where mailboxId = &#63; and status = &#63;.
    *
    * @param mailboxId the mailbox ID
    * @param status the status
    * @return the number of matching tasks
    * @throws SystemException if a system exception occurred
    */
    public int countByMailboxId(long mailboxId, java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the tasks where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching tasks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<at.mailbox.sync.model.Task> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the tasks where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of tasks
    * @param end the upper bound of the range of tasks (not inclusive)
    * @return the range of matching tasks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<at.mailbox.sync.model.Task> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the tasks where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of tasks
    * @param end the upper bound of the range of tasks (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching tasks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<at.mailbox.sync.model.Task> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first task in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching task
    * @throws at.mailbox.sync.NoSuchTaskException if a matching task could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task findByGroupId_First(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws at.mailbox.sync.NoSuchTaskException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first task in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching task, or <code>null</code> if a matching task could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task fetchByGroupId_First(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last task in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching task
    * @throws at.mailbox.sync.NoSuchTaskException if a matching task could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task findByGroupId_Last(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws at.mailbox.sync.NoSuchTaskException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last task in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching task, or <code>null</code> if a matching task could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task fetchByGroupId_Last(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the tasks before and after the current task in the ordered set where groupId = &#63;.
    *
    * @param taskId the primary key of the current task
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next task
    * @throws at.mailbox.sync.NoSuchTaskException if a task with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task[] findByGroupId_PrevAndNext(long taskId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws at.mailbox.sync.NoSuchTaskException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tasks where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tasks where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching tasks
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the task in the entity cache if it is enabled.
    *
    * @param task the task
    */
    public void cacheResult(at.mailbox.sync.model.Task task);

    /**
    * Caches the tasks in the entity cache if it is enabled.
    *
    * @param tasks the tasks
    */
    public void cacheResult(java.util.List<at.mailbox.sync.model.Task> tasks);

    /**
    * Creates a new task with the primary key. Does not add the task to the database.
    *
    * @param taskId the primary key for the new task
    * @return the new task
    */
    public at.mailbox.sync.model.Task create(long taskId);

    /**
    * Removes the task with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param taskId the primary key of the task
    * @return the task that was removed
    * @throws at.mailbox.sync.NoSuchTaskException if a task with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task remove(long taskId)
        throws at.mailbox.sync.NoSuchTaskException,
            com.liferay.portal.kernel.exception.SystemException;

    public at.mailbox.sync.model.Task updateImpl(
        at.mailbox.sync.model.Task task)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the task with the primary key or throws a {@link at.mailbox.sync.NoSuchTaskException} if it could not be found.
    *
    * @param taskId the primary key of the task
    * @return the task
    * @throws at.mailbox.sync.NoSuchTaskException if a task with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task findByPrimaryKey(long taskId)
        throws at.mailbox.sync.NoSuchTaskException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the task with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param taskId the primary key of the task
    * @return the task, or <code>null</code> if a task with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public at.mailbox.sync.model.Task fetchByPrimaryKey(long taskId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the tasks.
    *
    * @return the tasks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<at.mailbox.sync.model.Task> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<at.mailbox.sync.model.Task> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the tasks.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.mailbox.sync.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of tasks
    * @param end the upper bound of the range of tasks (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of tasks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<at.mailbox.sync.model.Task> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tasks from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tasks.
    *
    * @return the number of tasks
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
