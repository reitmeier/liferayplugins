package at.mailbox.sync.service.persistence;

import at.mailbox.sync.NoSuchTaskException;
import at.mailbox.sync.model.Task;
import at.mailbox.sync.model.impl.TaskImpl;
import at.mailbox.sync.model.impl.TaskModelImpl;
import at.mailbox.sync.service.persistence.TaskPersistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Claus Reitmeier
 * @see TaskPersistence
 * @see TaskUtil
 * @generated
 */
public class TaskPersistenceImpl extends BasePersistenceImpl<Task>
    implements TaskPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link TaskUtil} to access the task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = TaskImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskModelImpl.FINDER_CACHE_ENABLED, TaskImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskModelImpl.FINDER_CACHE_ENABLED, TaskImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAILBOXID =
        new FinderPath(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskModelImpl.FINDER_CACHE_ENABLED, TaskImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMailboxId",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAILBOXID =
        new FinderPath(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskModelImpl.FINDER_CACHE_ENABLED, TaskImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMailboxId",
            new String[] { Long.class.getName(), String.class.getName() },
            TaskModelImpl.MAILBOXID_COLUMN_BITMASK |
            TaskModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MAILBOXID = new FinderPath(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMailboxId",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_MAILBOXID_MAILBOXID_2 = "task.mailboxId = ? AND ";
    private static final String _FINDER_COLUMN_MAILBOXID_STATUS_1 = "task.status IS NULL";
    private static final String _FINDER_COLUMN_MAILBOXID_STATUS_2 = "task.status = ?";
    private static final String _FINDER_COLUMN_MAILBOXID_STATUS_3 = "(task.status IS NULL OR task.status = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskModelImpl.FINDER_CACHE_ENABLED, TaskImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskModelImpl.FINDER_CACHE_ENABLED, TaskImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            TaskModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "task.groupId = ?";
    private static final String _SQL_SELECT_TASK = "SELECT task FROM Task task";
    private static final String _SQL_SELECT_TASK_WHERE = "SELECT task FROM Task task WHERE ";
    private static final String _SQL_COUNT_TASK = "SELECT COUNT(task) FROM Task task";
    private static final String _SQL_COUNT_TASK_WHERE = "SELECT COUNT(task) FROM Task task WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "task.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Task exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Task exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(TaskPersistenceImpl.class);
    private static Task _nullTask = new TaskImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Task> toCacheModel() {
                return _nullTaskCacheModel;
            }
        };

    private static CacheModel<Task> _nullTaskCacheModel = new CacheModel<Task>() {
            @Override
            public Task toEntityModel() {
                return _nullTask;
            }
        };

    public TaskPersistenceImpl() {
        setModelClass(Task.class);
    }

    /**
     * Returns all the tasks where mailboxId = &#63; and status = &#63;.
     *
     * @param mailboxId the mailbox ID
     * @param status the status
     * @return the matching tasks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Task> findByMailboxId(long mailboxId, String status)
        throws SystemException {
        return findByMailboxId(mailboxId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Task> findByMailboxId(long mailboxId, String status, int start,
        int end) throws SystemException {
        return findByMailboxId(mailboxId, status, start, end, null);
    }

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
    @Override
    public List<Task> findByMailboxId(long mailboxId, String status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAILBOXID;
            finderArgs = new Object[] { mailboxId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAILBOXID;
            finderArgs = new Object[] {
                    mailboxId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<Task> list = (List<Task>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Task task : list) {
                if ((mailboxId != task.getMailboxId()) ||
                        !Validator.equals(status, task.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_TASK_WHERE);

            query.append(_FINDER_COLUMN_MAILBOXID_MAILBOXID_2);

            boolean bindStatus = false;

            if (status == null) {
                query.append(_FINDER_COLUMN_MAILBOXID_STATUS_1);
            } else if (status.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MAILBOXID_STATUS_3);
            } else {
                bindStatus = true;

                query.append(_FINDER_COLUMN_MAILBOXID_STATUS_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TaskModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mailboxId);

                if (bindStatus) {
                    qPos.add(status);
                }

                if (!pagination) {
                    list = (List<Task>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Task>(list);
                } else {
                    list = (List<Task>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

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
    @Override
    public Task findByMailboxId_First(long mailboxId, String status,
        OrderByComparator orderByComparator)
        throws NoSuchTaskException, SystemException {
        Task task = fetchByMailboxId_First(mailboxId, status, orderByComparator);

        if (task != null) {
            return task;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("mailboxId=");
        msg.append(mailboxId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTaskException(msg.toString());
    }

    /**
     * Returns the first task in the ordered set where mailboxId = &#63; and status = &#63;.
     *
     * @param mailboxId the mailbox ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching task, or <code>null</code> if a matching task could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task fetchByMailboxId_First(long mailboxId, String status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Task> list = findByMailboxId(mailboxId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Task findByMailboxId_Last(long mailboxId, String status,
        OrderByComparator orderByComparator)
        throws NoSuchTaskException, SystemException {
        Task task = fetchByMailboxId_Last(mailboxId, status, orderByComparator);

        if (task != null) {
            return task;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("mailboxId=");
        msg.append(mailboxId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTaskException(msg.toString());
    }

    /**
     * Returns the last task in the ordered set where mailboxId = &#63; and status = &#63;.
     *
     * @param mailboxId the mailbox ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching task, or <code>null</code> if a matching task could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task fetchByMailboxId_Last(long mailboxId, String status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByMailboxId(mailboxId, status);

        if (count == 0) {
            return null;
        }

        List<Task> list = findByMailboxId(mailboxId, status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Task[] findByMailboxId_PrevAndNext(long taskId, long mailboxId,
        String status, OrderByComparator orderByComparator)
        throws NoSuchTaskException, SystemException {
        Task task = findByPrimaryKey(taskId);

        Session session = null;

        try {
            session = openSession();

            Task[] array = new TaskImpl[3];

            array[0] = getByMailboxId_PrevAndNext(session, task, mailboxId,
                    status, orderByComparator, true);

            array[1] = task;

            array[2] = getByMailboxId_PrevAndNext(session, task, mailboxId,
                    status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Task getByMailboxId_PrevAndNext(Session session, Task task,
        long mailboxId, String status, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TASK_WHERE);

        query.append(_FINDER_COLUMN_MAILBOXID_MAILBOXID_2);

        boolean bindStatus = false;

        if (status == null) {
            query.append(_FINDER_COLUMN_MAILBOXID_STATUS_1);
        } else if (status.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_MAILBOXID_STATUS_3);
        } else {
            bindStatus = true;

            query.append(_FINDER_COLUMN_MAILBOXID_STATUS_2);
        }

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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TaskModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(mailboxId);

        if (bindStatus) {
            qPos.add(status);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(task);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Task> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the tasks where mailboxId = &#63; and status = &#63; from the database.
     *
     * @param mailboxId the mailbox ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByMailboxId(long mailboxId, String status)
        throws SystemException {
        for (Task task : findByMailboxId(mailboxId, status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(task);
        }
    }

    /**
     * Returns the number of tasks where mailboxId = &#63; and status = &#63;.
     *
     * @param mailboxId the mailbox ID
     * @param status the status
     * @return the number of matching tasks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByMailboxId(long mailboxId, String status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MAILBOXID;

        Object[] finderArgs = new Object[] { mailboxId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_TASK_WHERE);

            query.append(_FINDER_COLUMN_MAILBOXID_MAILBOXID_2);

            boolean bindStatus = false;

            if (status == null) {
                query.append(_FINDER_COLUMN_MAILBOXID_STATUS_1);
            } else if (status.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MAILBOXID_STATUS_3);
            } else {
                bindStatus = true;

                query.append(_FINDER_COLUMN_MAILBOXID_STATUS_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mailboxId);

                if (bindStatus) {
                    qPos.add(status);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the tasks where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching tasks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Task> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Task> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

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
    @Override
    public List<Task> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<Task> list = (List<Task>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Task task : list) {
                if ((groupId != task.getGroupId())) {
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
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_TASK_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TaskModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Task>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Task>(list);
                } else {
                    list = (List<Task>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first task in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching task
     * @throws at.mailbox.sync.NoSuchTaskException if a matching task could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchTaskException, SystemException {
        Task task = fetchByGroupId_First(groupId, orderByComparator);

        if (task != null) {
            return task;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTaskException(msg.toString());
    }

    /**
     * Returns the first task in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching task, or <code>null</code> if a matching task could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Task> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last task in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching task
     * @throws at.mailbox.sync.NoSuchTaskException if a matching task could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchTaskException, SystemException {
        Task task = fetchByGroupId_Last(groupId, orderByComparator);

        if (task != null) {
            return task;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTaskException(msg.toString());
    }

    /**
     * Returns the last task in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching task, or <code>null</code> if a matching task could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Task> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Task[] findByGroupId_PrevAndNext(long taskId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchTaskException, SystemException {
        Task task = findByPrimaryKey(taskId);

        Session session = null;

        try {
            session = openSession();

            Task[] array = new TaskImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, task, groupId,
                    orderByComparator, true);

            array[1] = task;

            array[2] = getByGroupId_PrevAndNext(session, task, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Task getByGroupId_PrevAndNext(Session session, Task task,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TASK_WHERE);

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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TaskModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(task);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Task> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the tasks where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Task task : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(task);
        }
    }

    /**
     * Returns the number of tasks where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching tasks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TASK_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the task in the entity cache if it is enabled.
     *
     * @param task the task
     */
    @Override
    public void cacheResult(Task task) {
        EntityCacheUtil.putResult(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskImpl.class, task.getPrimaryKey(), task);

        task.resetOriginalValues();
    }

    /**
     * Caches the tasks in the entity cache if it is enabled.
     *
     * @param tasks the tasks
     */
    @Override
    public void cacheResult(List<Task> tasks) {
        for (Task task : tasks) {
            if (EntityCacheUtil.getResult(TaskModelImpl.ENTITY_CACHE_ENABLED,
                        TaskImpl.class, task.getPrimaryKey()) == null) {
                cacheResult(task);
            } else {
                task.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all tasks.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(TaskImpl.class.getName());
        }

        EntityCacheUtil.clearCache(TaskImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the task.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Task task) {
        EntityCacheUtil.removeResult(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskImpl.class, task.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Task> tasks) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Task task : tasks) {
            EntityCacheUtil.removeResult(TaskModelImpl.ENTITY_CACHE_ENABLED,
                TaskImpl.class, task.getPrimaryKey());
        }
    }

    /**
     * Creates a new task with the primary key. Does not add the task to the database.
     *
     * @param taskId the primary key for the new task
     * @return the new task
     */
    @Override
    public Task create(long taskId) {
        Task task = new TaskImpl();

        task.setNew(true);
        task.setPrimaryKey(taskId);

        return task;
    }

    /**
     * Removes the task with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param taskId the primary key of the task
     * @return the task that was removed
     * @throws at.mailbox.sync.NoSuchTaskException if a task with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task remove(long taskId) throws NoSuchTaskException, SystemException {
        return remove((Serializable) taskId);
    }

    /**
     * Removes the task with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the task
     * @return the task that was removed
     * @throws at.mailbox.sync.NoSuchTaskException if a task with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task remove(Serializable primaryKey)
        throws NoSuchTaskException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Task task = (Task) session.get(TaskImpl.class, primaryKey);

            if (task == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(task);
        } catch (NoSuchTaskException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Task removeImpl(Task task) throws SystemException {
        task = toUnwrappedModel(task);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(task)) {
                task = (Task) session.get(TaskImpl.class,
                        task.getPrimaryKeyObj());
            }

            if (task != null) {
                session.delete(task);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (task != null) {
            clearCache(task);
        }

        return task;
    }

    @Override
    public Task updateImpl(at.mailbox.sync.model.Task task)
        throws SystemException {
        task = toUnwrappedModel(task);

        boolean isNew = task.isNew();

        TaskModelImpl taskModelImpl = (TaskModelImpl) task;

        Session session = null;

        try {
            session = openSession();

            if (task.isNew()) {
                session.save(task);

                task.setNew(false);
            } else {
                session.merge(task);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !TaskModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((taskModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAILBOXID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        taskModelImpl.getOriginalMailboxId(),
                        taskModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAILBOXID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAILBOXID,
                    args);

                args = new Object[] {
                        taskModelImpl.getMailboxId(), taskModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAILBOXID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAILBOXID,
                    args);
            }

            if ((taskModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { taskModelImpl.getOriginalGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { taskModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(TaskModelImpl.ENTITY_CACHE_ENABLED,
            TaskImpl.class, task.getPrimaryKey(), task);

        return task;
    }

    protected Task toUnwrappedModel(Task task) {
        if (task instanceof TaskImpl) {
            return task;
        }

        TaskImpl taskImpl = new TaskImpl();

        taskImpl.setNew(task.isNew());
        taskImpl.setPrimaryKey(task.getPrimaryKey());

        taskImpl.setTaskId(task.getTaskId());
        taskImpl.setGroupId(task.getGroupId());
        taskImpl.setCompanyId(task.getCompanyId());
        taskImpl.setUserId(task.getUserId());
        taskImpl.setUserName(task.getUserName());
        taskImpl.setCreateDate(task.getCreateDate());
        taskImpl.setModifiedDate(task.getModifiedDate());
        taskImpl.setStatus(task.getStatus());
        taskImpl.setDescription(task.getDescription());
        taskImpl.setMailboxId(task.getMailboxId());
        taskImpl.setPermissionUserGroupId(task.getPermissionUserGroupId());
        taskImpl.setEventCalendarId(task.getEventCalendarId());
        taskImpl.setDocumentFolderId(task.getDocumentFolderId());
        taskImpl.setWebcontentFolderId(task.getWebcontentFolderId());
        taskImpl.setVocabularyId(task.getVocabularyId());
        taskImpl.setPeriod(task.getPeriod());
        taskImpl.setClamavServerIP(task.getClamavServerIP());
        taskImpl.setClamavPort(task.getClamavPort());

        return taskImpl;
    }

    /**
     * Returns the task with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the task
     * @return the task
     * @throws at.mailbox.sync.NoSuchTaskException if a task with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task findByPrimaryKey(Serializable primaryKey)
        throws NoSuchTaskException, SystemException {
        Task task = fetchByPrimaryKey(primaryKey);

        if (task == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return task;
    }

    /**
     * Returns the task with the primary key or throws a {@link at.mailbox.sync.NoSuchTaskException} if it could not be found.
     *
     * @param taskId the primary key of the task
     * @return the task
     * @throws at.mailbox.sync.NoSuchTaskException if a task with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task findByPrimaryKey(long taskId)
        throws NoSuchTaskException, SystemException {
        return findByPrimaryKey((Serializable) taskId);
    }

    /**
     * Returns the task with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the task
     * @return the task, or <code>null</code> if a task with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Task task = (Task) EntityCacheUtil.getResult(TaskModelImpl.ENTITY_CACHE_ENABLED,
                TaskImpl.class, primaryKey);

        if (task == _nullTask) {
            return null;
        }

        if (task == null) {
            Session session = null;

            try {
                session = openSession();

                task = (Task) session.get(TaskImpl.class, primaryKey);

                if (task != null) {
                    cacheResult(task);
                } else {
                    EntityCacheUtil.putResult(TaskModelImpl.ENTITY_CACHE_ENABLED,
                        TaskImpl.class, primaryKey, _nullTask);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(TaskModelImpl.ENTITY_CACHE_ENABLED,
                    TaskImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return task;
    }

    /**
     * Returns the task with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param taskId the primary key of the task
     * @return the task, or <code>null</code> if a task with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Task fetchByPrimaryKey(long taskId) throws SystemException {
        return fetchByPrimaryKey((Serializable) taskId);
    }

    /**
     * Returns all the tasks.
     *
     * @return the tasks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Task> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Task> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Task> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Task> list = (List<Task>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_TASK);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_TASK;

                if (pagination) {
                    sql = sql.concat(TaskModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Task>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Task>(list);
                } else {
                    list = (List<Task>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the tasks from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Task task : findAll()) {
            remove(task);
        }
    }

    /**
     * Returns the number of tasks.
     *
     * @return the number of tasks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_TASK);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the task persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.at.mailbox.sync.model.Task")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Task>> listenersList = new ArrayList<ModelListener<Task>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Task>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(TaskImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
