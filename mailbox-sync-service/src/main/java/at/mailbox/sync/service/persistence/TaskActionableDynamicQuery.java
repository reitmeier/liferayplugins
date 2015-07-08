package at.mailbox.sync.service.persistence;

import at.mailbox.sync.model.Task;
import at.mailbox.sync.service.TaskLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Claus Reitmeier
 * @generated
 */
public abstract class TaskActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TaskActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TaskLocalServiceUtil.getService());
        setClass(Task.class);

        setClassLoader(at.mailbox.sync.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("taskId");
    }
}
