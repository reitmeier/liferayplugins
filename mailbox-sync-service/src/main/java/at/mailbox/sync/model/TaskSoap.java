package at.mailbox.sync.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.mailbox.sync.service.http.TaskServiceSoap}.
 *
 * @author Claus Reitmeier
 * @see at.mailbox.sync.service.http.TaskServiceSoap
 * @generated
 */
public class TaskSoap implements Serializable {
    private long _taskId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _status;
    private String _description;
    private long _mailboxId;
    private long _permissionUserGroupId;
    private long _eventCalendarId;
    private long _documentFolderId;
    private long _webcontentFolderId;
    private long _vocabularyId;
    private long _period;
    private String _clamavServerIP;
    private int _clamavPort;

    public TaskSoap() {
    }

    public static TaskSoap toSoapModel(Task model) {
        TaskSoap soapModel = new TaskSoap();

        soapModel.setTaskId(model.getTaskId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setStatus(model.getStatus());
        soapModel.setDescription(model.getDescription());
        soapModel.setMailboxId(model.getMailboxId());
        soapModel.setPermissionUserGroupId(model.getPermissionUserGroupId());
        soapModel.setEventCalendarId(model.getEventCalendarId());
        soapModel.setDocumentFolderId(model.getDocumentFolderId());
        soapModel.setWebcontentFolderId(model.getWebcontentFolderId());
        soapModel.setVocabularyId(model.getVocabularyId());
        soapModel.setPeriod(model.getPeriod());
        soapModel.setClamavServerIP(model.getClamavServerIP());
        soapModel.setClamavPort(model.getClamavPort());

        return soapModel;
    }

    public static TaskSoap[] toSoapModels(Task[] models) {
        TaskSoap[] soapModels = new TaskSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static TaskSoap[][] toSoapModels(Task[][] models) {
        TaskSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new TaskSoap[models.length][models[0].length];
        } else {
            soapModels = new TaskSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static TaskSoap[] toSoapModels(List<Task> models) {
        List<TaskSoap> soapModels = new ArrayList<TaskSoap>(models.size());

        for (Task model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new TaskSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _taskId;
    }

    public void setPrimaryKey(long pk) {
        setTaskId(pk);
    }

    public long getTaskId() {
        return _taskId;
    }

    public void setTaskId(long taskId) {
        _taskId = taskId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public long getMailboxId() {
        return _mailboxId;
    }

    public void setMailboxId(long mailboxId) {
        _mailboxId = mailboxId;
    }

    public long getPermissionUserGroupId() {
        return _permissionUserGroupId;
    }

    public void setPermissionUserGroupId(long permissionUserGroupId) {
        _permissionUserGroupId = permissionUserGroupId;
    }

    public long getEventCalendarId() {
        return _eventCalendarId;
    }

    public void setEventCalendarId(long eventCalendarId) {
        _eventCalendarId = eventCalendarId;
    }

    public long getDocumentFolderId() {
        return _documentFolderId;
    }

    public void setDocumentFolderId(long documentFolderId) {
        _documentFolderId = documentFolderId;
    }

    public long getWebcontentFolderId() {
        return _webcontentFolderId;
    }

    public void setWebcontentFolderId(long webcontentFolderId) {
        _webcontentFolderId = webcontentFolderId;
    }

    public long getVocabularyId() {
        return _vocabularyId;
    }

    public void setVocabularyId(long vocabularyId) {
        _vocabularyId = vocabularyId;
    }

    public long getPeriod() {
        return _period;
    }

    public void setPeriod(long period) {
        _period = period;
    }

    public String getClamavServerIP() {
        return _clamavServerIP;
    }

    public void setClamavServerIP(String clamavServerIP) {
        _clamavServerIP = clamavServerIP;
    }

    public int getClamavPort() {
        return _clamavPort;
    }

    public void setClamavPort(int clamavPort) {
        _clamavPort = clamavPort;
    }
}
