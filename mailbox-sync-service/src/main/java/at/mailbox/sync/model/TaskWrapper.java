package at.mailbox.sync.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Task}.
 * </p>
 *
 * @author Claus Reitmeier
 * @see Task
 * @generated
 */
public class TaskWrapper implements Task, ModelWrapper<Task> {
    private Task _task;

    public TaskWrapper(Task task) {
        _task = task;
    }

    @Override
    public Class<?> getModelClass() {
        return Task.class;
    }

    @Override
    public String getModelClassName() {
        return Task.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("taskId", getTaskId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("status", getStatus());
        attributes.put("description", getDescription());
        attributes.put("mailboxId", getMailboxId());
        attributes.put("permissionUserGroupId", getPermissionUserGroupId());
        attributes.put("eventCalendarId", getEventCalendarId());
        attributes.put("documentFolderId", getDocumentFolderId());
        attributes.put("webcontentFolderId", getWebcontentFolderId());
        attributes.put("vocabularyId", getVocabularyId());
        attributes.put("period", getPeriod());
        attributes.put("clamavServerIP", getClamavServerIP());
        attributes.put("clamavPort", getClamavPort());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long taskId = (Long) attributes.get("taskId");

        if (taskId != null) {
            setTaskId(taskId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long mailboxId = (Long) attributes.get("mailboxId");

        if (mailboxId != null) {
            setMailboxId(mailboxId);
        }

        Long permissionUserGroupId = (Long) attributes.get(
                "permissionUserGroupId");

        if (permissionUserGroupId != null) {
            setPermissionUserGroupId(permissionUserGroupId);
        }

        Long eventCalendarId = (Long) attributes.get("eventCalendarId");

        if (eventCalendarId != null) {
            setEventCalendarId(eventCalendarId);
        }

        Long documentFolderId = (Long) attributes.get("documentFolderId");

        if (documentFolderId != null) {
            setDocumentFolderId(documentFolderId);
        }

        Long webcontentFolderId = (Long) attributes.get("webcontentFolderId");

        if (webcontentFolderId != null) {
            setWebcontentFolderId(webcontentFolderId);
        }

        Long vocabularyId = (Long) attributes.get("vocabularyId");

        if (vocabularyId != null) {
            setVocabularyId(vocabularyId);
        }

        Long period = (Long) attributes.get("period");

        if (period != null) {
            setPeriod(period);
        }

        String clamavServerIP = (String) attributes.get("clamavServerIP");

        if (clamavServerIP != null) {
            setClamavServerIP(clamavServerIP);
        }

        Integer clamavPort = (Integer) attributes.get("clamavPort");

        if (clamavPort != null) {
            setClamavPort(clamavPort);
        }
    }

    /**
    * Returns the primary key of this task.
    *
    * @return the primary key of this task
    */
    @Override
    public long getPrimaryKey() {
        return _task.getPrimaryKey();
    }

    /**
    * Sets the primary key of this task.
    *
    * @param primaryKey the primary key of this task
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _task.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the task ID of this task.
    *
    * @return the task ID of this task
    */
    @Override
    public long getTaskId() {
        return _task.getTaskId();
    }

    /**
    * Sets the task ID of this task.
    *
    * @param taskId the task ID of this task
    */
    @Override
    public void setTaskId(long taskId) {
        _task.setTaskId(taskId);
    }

    /**
    * Returns the group ID of this task.
    *
    * @return the group ID of this task
    */
    @Override
    public long getGroupId() {
        return _task.getGroupId();
    }

    /**
    * Sets the group ID of this task.
    *
    * @param groupId the group ID of this task
    */
    @Override
    public void setGroupId(long groupId) {
        _task.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this task.
    *
    * @return the company ID of this task
    */
    @Override
    public long getCompanyId() {
        return _task.getCompanyId();
    }

    /**
    * Sets the company ID of this task.
    *
    * @param companyId the company ID of this task
    */
    @Override
    public void setCompanyId(long companyId) {
        _task.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this task.
    *
    * @return the user ID of this task
    */
    @Override
    public long getUserId() {
        return _task.getUserId();
    }

    /**
    * Sets the user ID of this task.
    *
    * @param userId the user ID of this task
    */
    @Override
    public void setUserId(long userId) {
        _task.setUserId(userId);
    }

    /**
    * Returns the user uuid of this task.
    *
    * @return the user uuid of this task
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _task.getUserUuid();
    }

    /**
    * Sets the user uuid of this task.
    *
    * @param userUuid the user uuid of this task
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _task.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this task.
    *
    * @return the user name of this task
    */
    @Override
    public java.lang.String getUserName() {
        return _task.getUserName();
    }

    /**
    * Sets the user name of this task.
    *
    * @param userName the user name of this task
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _task.setUserName(userName);
    }

    /**
    * Returns the create date of this task.
    *
    * @return the create date of this task
    */
    @Override
    public java.util.Date getCreateDate() {
        return _task.getCreateDate();
    }

    /**
    * Sets the create date of this task.
    *
    * @param createDate the create date of this task
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _task.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this task.
    *
    * @return the modified date of this task
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _task.getModifiedDate();
    }

    /**
    * Sets the modified date of this task.
    *
    * @param modifiedDate the modified date of this task
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _task.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the status of this task.
    *
    * @return the status of this task
    */
    @Override
    public java.lang.String getStatus() {
        return _task.getStatus();
    }

    /**
    * Sets the status of this task.
    *
    * @param status the status of this task
    */
    @Override
    public void setStatus(java.lang.String status) {
        _task.setStatus(status);
    }

    /**
    * Returns the description of this task.
    *
    * @return the description of this task
    */
    @Override
    public java.lang.String getDescription() {
        return _task.getDescription();
    }

    /**
    * Sets the description of this task.
    *
    * @param description the description of this task
    */
    @Override
    public void setDescription(java.lang.String description) {
        _task.setDescription(description);
    }

    /**
    * Returns the mailbox ID of this task.
    *
    * @return the mailbox ID of this task
    */
    @Override
    public long getMailboxId() {
        return _task.getMailboxId();
    }

    /**
    * Sets the mailbox ID of this task.
    *
    * @param mailboxId the mailbox ID of this task
    */
    @Override
    public void setMailboxId(long mailboxId) {
        _task.setMailboxId(mailboxId);
    }

    /**
    * Returns the permission user group ID of this task.
    *
    * @return the permission user group ID of this task
    */
    @Override
    public long getPermissionUserGroupId() {
        return _task.getPermissionUserGroupId();
    }

    /**
    * Sets the permission user group ID of this task.
    *
    * @param permissionUserGroupId the permission user group ID of this task
    */
    @Override
    public void setPermissionUserGroupId(long permissionUserGroupId) {
        _task.setPermissionUserGroupId(permissionUserGroupId);
    }

    /**
    * Returns the event calendar ID of this task.
    *
    * @return the event calendar ID of this task
    */
    @Override
    public long getEventCalendarId() {
        return _task.getEventCalendarId();
    }

    /**
    * Sets the event calendar ID of this task.
    *
    * @param eventCalendarId the event calendar ID of this task
    */
    @Override
    public void setEventCalendarId(long eventCalendarId) {
        _task.setEventCalendarId(eventCalendarId);
    }

    /**
    * Returns the document folder ID of this task.
    *
    * @return the document folder ID of this task
    */
    @Override
    public long getDocumentFolderId() {
        return _task.getDocumentFolderId();
    }

    /**
    * Sets the document folder ID of this task.
    *
    * @param documentFolderId the document folder ID of this task
    */
    @Override
    public void setDocumentFolderId(long documentFolderId) {
        _task.setDocumentFolderId(documentFolderId);
    }

    /**
    * Returns the webcontent folder ID of this task.
    *
    * @return the webcontent folder ID of this task
    */
    @Override
    public long getWebcontentFolderId() {
        return _task.getWebcontentFolderId();
    }

    /**
    * Sets the webcontent folder ID of this task.
    *
    * @param webcontentFolderId the webcontent folder ID of this task
    */
    @Override
    public void setWebcontentFolderId(long webcontentFolderId) {
        _task.setWebcontentFolderId(webcontentFolderId);
    }

    /**
    * Returns the vocabulary ID of this task.
    *
    * @return the vocabulary ID of this task
    */
    @Override
    public long getVocabularyId() {
        return _task.getVocabularyId();
    }

    /**
    * Sets the vocabulary ID of this task.
    *
    * @param vocabularyId the vocabulary ID of this task
    */
    @Override
    public void setVocabularyId(long vocabularyId) {
        _task.setVocabularyId(vocabularyId);
    }

    /**
    * Returns the period of this task.
    *
    * @return the period of this task
    */
    @Override
    public long getPeriod() {
        return _task.getPeriod();
    }

    /**
    * Sets the period of this task.
    *
    * @param period the period of this task
    */
    @Override
    public void setPeriod(long period) {
        _task.setPeriod(period);
    }

    /**
    * Returns the clamav server i p of this task.
    *
    * @return the clamav server i p of this task
    */
    @Override
    public java.lang.String getClamavServerIP() {
        return _task.getClamavServerIP();
    }

    /**
    * Sets the clamav server i p of this task.
    *
    * @param clamavServerIP the clamav server i p of this task
    */
    @Override
    public void setClamavServerIP(java.lang.String clamavServerIP) {
        _task.setClamavServerIP(clamavServerIP);
    }

    /**
    * Returns the clamav port of this task.
    *
    * @return the clamav port of this task
    */
    @Override
    public int getClamavPort() {
        return _task.getClamavPort();
    }

    /**
    * Sets the clamav port of this task.
    *
    * @param clamavPort the clamav port of this task
    */
    @Override
    public void setClamavPort(int clamavPort) {
        _task.setClamavPort(clamavPort);
    }

    @Override
    public boolean isNew() {
        return _task.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _task.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _task.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _task.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _task.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _task.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _task.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _task.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _task.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _task.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _task.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new TaskWrapper((Task) _task.clone());
    }

    @Override
    public int compareTo(at.mailbox.sync.model.Task task) {
        return _task.compareTo(task);
    }

    @Override
    public int hashCode() {
        return _task.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<at.mailbox.sync.model.Task> toCacheModel() {
        return _task.toCacheModel();
    }

    @Override
    public at.mailbox.sync.model.Task toEscapedModel() {
        return new TaskWrapper(_task.toEscapedModel());
    }

    @Override
    public at.mailbox.sync.model.Task toUnescapedModel() {
        return new TaskWrapper(_task.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _task.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _task.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _task.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TaskWrapper)) {
            return false;
        }

        TaskWrapper taskWrapper = (TaskWrapper) obj;

        if (Validator.equals(_task, taskWrapper._task)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Task getWrappedTask() {
        return _task;
    }

    @Override
    public Task getWrappedModel() {
        return _task;
    }

    @Override
    public void resetOriginalValues() {
        _task.resetOriginalValues();
    }
}
