package at.mailbox.sync.service.impl;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;

import at.mailbox.sync.exceptions.MailboxUserSecretException;
import at.mailbox.sync.helper.ErrorHelper;
import at.mailbox.sync.model.Mailbox;
import at.mailbox.sync.model.Task;
import at.mailbox.sync.service.MailboxLocalServiceUtil;
import at.mailbox.sync.service.TaskLocalServiceUtil;
import at.mailbox.sync.service.base.TaskLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.mailbox.sync.service.TaskLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Claus Reitmeier
 * @see at.mailbox.sync.service.base.TaskLocalServiceBaseImpl
 * @see at.mailbox.sync.service.TaskLocalServiceUtil
 */
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link at.mailbox.sync.service.TaskLocalServiceUtil} to access the task local service.
     */

@Override
public Task addTask() {
		// TODO Auto-generated method stub
		return null;
	}

public enum TaskStatus {INACTIVE, ACTIVE, RUNNING, ARCHIVED};


public Task addTask(long userId, long groupId, String description, Long mailboxId, Long permissionUserGroupId, Long eventCalendarId, Long documentFolderId, Long webcontentFolderId, Long vocabularyId, Long period, String clamavServerIP, Integer clamavPort ,ServiceContext serviceContext ) 
		throws PortalException, SystemException {
	User user = userPersistence.findByPrimaryKey(userId);
	Date now = new Date();
	long taskId= counterLocalService.increment(Task.class.getName());
	Task task= taskPersistence.create(taskId);
	task.setStatus(TaskStatus.INACTIVE.name());
	task.setDescription(description);
	if (mailboxId!=null) {
		task.setMailboxId(mailboxId);
	}
	if (permissionUserGroupId!=null) {
		task.setPermissionUserGroupId(permissionUserGroupId);
	}
	if (eventCalendarId!=null) {
		task.setEventCalendarId(eventCalendarId);
	}
	if (documentFolderId!=null){
		task.setDocumentFolderId(documentFolderId);
	}
	if (webcontentFolderId!=null) {
		task.setWebcontentFolderId(webcontentFolderId);
	}
	if(vocabularyId!=null) {
		task.setVocabularyId(vocabularyId);
	}
	if (period!=null) {
		task.setPeriod(period);
	}
	if (clamavServerIP!=null) {
		task.setClamavServerIP(clamavServerIP);
	}
	if (clamavPort!=null){
		task.setClamavPort(clamavPort);
	}
	task.setGroupId(groupId);
	task.setCompanyId(user.getCompanyId());
	task.setUserId(user.getUserId());
	task.setCreateDate(serviceContext.getCreateDate(now));
	task.setModifiedDate(serviceContext.getModifiedDate(now));
	super.addTask(task);
	return task;
	
	}
public Task deleteTask(Task task) throws SystemException  {
	if (task.getStatus().equals(TaskStatus.ARCHIVED.name())||task.getStatus().equals(TaskStatus.INACTIVE.name())) {
		return taskPersistence.remove(task);
	} else {
		throw new SystemException("delete-requires-status-archived-or-inactive");
	}
			
	
}
public Task deleteTask(long taskId)
 		throws PortalException, SystemException {
	Task task= taskPersistence.findByPrimaryKey(taskId);
	return deleteTask(task);
	}

public List<Task> getTaskByMailboxId(long mailboxId, String status) throws SystemException {
	if (status!=null) {
		return taskPersistence.findByMailboxId(mailboxId, status);	
	} else {
		return taskPersistence.findByMailboxId(mailboxId, null);	
	}
}
public Task updateTask(long userId, long taskId, String status, String description, Long mailboxId, Long permissionUserGroupId, Long eventCalendarId, Long documentFolderId, Long webcontentFolderId, Long vocabularyId, Long period, String clamavServerIP, Integer clamavPort ,ServiceContext serviceContext  ) throws PortalException, SystemException {
	User user = userPersistence.findByPrimaryKey(userId);
	Date now = new Date();
	Task task = TaskLocalServiceUtil.fetchTask(taskId);
	task.setModifiedDate(serviceContext.getModifiedDate(now));
	task.setStatus(status);
	task.setDescription(description);
	if (mailboxId!=null) {
		task.setMailboxId(mailboxId);
	}
	if (permissionUserGroupId!=null) {
		task.setPermissionUserGroupId(permissionUserGroupId);
	}
	if (eventCalendarId!=null) {
		task.setEventCalendarId(eventCalendarId);
	}
	if (documentFolderId!=null){
		task.setDocumentFolderId(documentFolderId);
	}
	if (webcontentFolderId!=null) {
		task.setWebcontentFolderId(webcontentFolderId);
	}
	if(vocabularyId!=null) {
		task.setVocabularyId(vocabularyId);
	}
	if (period!=null) {
		task.setPeriod(period);
	}
	if (clamavServerIP!=null) {
		task.setClamavServerIP(clamavServerIP);
	}
	if (clamavPort!=null){
		task.setClamavPort(clamavPort);
	}
	task.setCompanyId(user.getCompanyId());
	task.setUserId(user.getUserId());
	task.setCreateDate(serviceContext.getCreateDate(now));
	task.setModifiedDate(serviceContext.getModifiedDate(now));
	super.updateTask(task);
	return task;
}

public List<Task> getTaskByGroupId(long groupId) throws SystemException {
	return taskPersistence.findByGroupId(groupId);
}



}
