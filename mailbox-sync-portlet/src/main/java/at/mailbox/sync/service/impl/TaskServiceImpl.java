package at.mailbox.sync.service.impl;

import at.mailbox.sync.service.base.TaskServiceBaseImpl;

/**
 * The implementation of the task remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.mailbox.sync.service.TaskService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Claus Reitmeier
 * @see at.mailbox.sync.service.base.TaskServiceBaseImpl
 * @see at.mailbox.sync.service.TaskServiceUtil
 */
public class TaskServiceImpl extends TaskServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link at.mailbox.sync.service.TaskServiceUtil} to access the task remote service.
     */
}
