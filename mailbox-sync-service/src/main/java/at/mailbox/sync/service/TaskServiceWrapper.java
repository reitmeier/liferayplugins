package at.mailbox.sync.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TaskService}.
 *
 * @author Claus Reitmeier
 * @see TaskService
 * @generated
 */
public class TaskServiceWrapper implements TaskService,
    ServiceWrapper<TaskService> {
    private TaskService _taskService;

    public TaskServiceWrapper(TaskService taskService) {
        _taskService = taskService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _taskService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _taskService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _taskService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TaskService getWrappedTaskService() {
        return _taskService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTaskService(TaskService taskService) {
        _taskService = taskService;
    }

    @Override
    public TaskService getWrappedService() {
        return _taskService;
    }

    @Override
    public void setWrappedService(TaskService taskService) {
        _taskService = taskService;
    }
}
