package at.mailbox.sync.model;

import at.mailbox.sync.service.ClpSerializer;
import at.mailbox.sync.service.TaskLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TaskClp extends BaseModelImpl<Task> implements Task {
    private long _taskId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
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
    private BaseModel<?> _taskRemoteModel;
    private Class<?> _clpSerializerClass = at.mailbox.sync.service.ClpSerializer.class;

    public TaskClp() {
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
    public long getPrimaryKey() {
        return _taskId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setTaskId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _taskId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getTaskId() {
        return _taskId;
    }

    @Override
    public void setTaskId(long taskId) {
        _taskId = taskId;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setTaskId", long.class);

                method.invoke(_taskRemoteModel, taskId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_taskRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_taskRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_taskRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_taskRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_taskRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_taskRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatus() {
        return _status;
    }

    @Override
    public void setStatus(String status) {
        _status = status;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", String.class);

                method.invoke(_taskRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_taskRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getMailboxId() {
        return _mailboxId;
    }

    @Override
    public void setMailboxId(long mailboxId) {
        _mailboxId = mailboxId;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setMailboxId", long.class);

                method.invoke(_taskRemoteModel, mailboxId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPermissionUserGroupId() {
        return _permissionUserGroupId;
    }

    @Override
    public void setPermissionUserGroupId(long permissionUserGroupId) {
        _permissionUserGroupId = permissionUserGroupId;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setPermissionUserGroupId",
                        long.class);

                method.invoke(_taskRemoteModel, permissionUserGroupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getEventCalendarId() {
        return _eventCalendarId;
    }

    @Override
    public void setEventCalendarId(long eventCalendarId) {
        _eventCalendarId = eventCalendarId;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setEventCalendarId", long.class);

                method.invoke(_taskRemoteModel, eventCalendarId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDocumentFolderId() {
        return _documentFolderId;
    }

    @Override
    public void setDocumentFolderId(long documentFolderId) {
        _documentFolderId = documentFolderId;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setDocumentFolderId",
                        long.class);

                method.invoke(_taskRemoteModel, documentFolderId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getWebcontentFolderId() {
        return _webcontentFolderId;
    }

    @Override
    public void setWebcontentFolderId(long webcontentFolderId) {
        _webcontentFolderId = webcontentFolderId;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setWebcontentFolderId",
                        long.class);

                method.invoke(_taskRemoteModel, webcontentFolderId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getVocabularyId() {
        return _vocabularyId;
    }

    @Override
    public void setVocabularyId(long vocabularyId) {
        _vocabularyId = vocabularyId;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setVocabularyId", long.class);

                method.invoke(_taskRemoteModel, vocabularyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPeriod() {
        return _period;
    }

    @Override
    public void setPeriod(long period) {
        _period = period;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setPeriod", long.class);

                method.invoke(_taskRemoteModel, period);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getClamavServerIP() {
        return _clamavServerIP;
    }

    @Override
    public void setClamavServerIP(String clamavServerIP) {
        _clamavServerIP = clamavServerIP;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setClamavServerIP",
                        String.class);

                method.invoke(_taskRemoteModel, clamavServerIP);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getClamavPort() {
        return _clamavPort;
    }

    @Override
    public void setClamavPort(int clamavPort) {
        _clamavPort = clamavPort;

        if (_taskRemoteModel != null) {
            try {
                Class<?> clazz = _taskRemoteModel.getClass();

                Method method = clazz.getMethod("setClamavPort", int.class);

                method.invoke(_taskRemoteModel, clamavPort);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getTaskRemoteModel() {
        return _taskRemoteModel;
    }

    public void setTaskRemoteModel(BaseModel<?> taskRemoteModel) {
        _taskRemoteModel = taskRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _taskRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_taskRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            TaskLocalServiceUtil.addTask(this);
        } else {
            TaskLocalServiceUtil.updateTask(this);
        }
    }

    @Override
    public Task toEscapedModel() {
        return (Task) ProxyUtil.newProxyInstance(Task.class.getClassLoader(),
            new Class[] { Task.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        TaskClp clone = new TaskClp();

        clone.setTaskId(getTaskId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setStatus(getStatus());
        clone.setDescription(getDescription());
        clone.setMailboxId(getMailboxId());
        clone.setPermissionUserGroupId(getPermissionUserGroupId());
        clone.setEventCalendarId(getEventCalendarId());
        clone.setDocumentFolderId(getDocumentFolderId());
        clone.setWebcontentFolderId(getWebcontentFolderId());
        clone.setVocabularyId(getVocabularyId());
        clone.setPeriod(getPeriod());
        clone.setClamavServerIP(getClamavServerIP());
        clone.setClamavPort(getClamavPort());

        return clone;
    }

    @Override
    public int compareTo(Task task) {
        long primaryKey = task.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TaskClp)) {
            return false;
        }

        TaskClp task = (TaskClp) obj;

        long primaryKey = task.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(37);

        sb.append("{taskId=");
        sb.append(getTaskId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", mailboxId=");
        sb.append(getMailboxId());
        sb.append(", permissionUserGroupId=");
        sb.append(getPermissionUserGroupId());
        sb.append(", eventCalendarId=");
        sb.append(getEventCalendarId());
        sb.append(", documentFolderId=");
        sb.append(getDocumentFolderId());
        sb.append(", webcontentFolderId=");
        sb.append(getWebcontentFolderId());
        sb.append(", vocabularyId=");
        sb.append(getVocabularyId());
        sb.append(", period=");
        sb.append(getPeriod());
        sb.append(", clamavServerIP=");
        sb.append(getClamavServerIP());
        sb.append(", clamavPort=");
        sb.append(getClamavPort());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(58);

        sb.append("<model><model-name>");
        sb.append("at.mailbox.sync.model.Task");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>taskId</column-name><column-value><![CDATA[");
        sb.append(getTaskId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mailboxId</column-name><column-value><![CDATA[");
        sb.append(getMailboxId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>permissionUserGroupId</column-name><column-value><![CDATA[");
        sb.append(getPermissionUserGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>eventCalendarId</column-name><column-value><![CDATA[");
        sb.append(getEventCalendarId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>documentFolderId</column-name><column-value><![CDATA[");
        sb.append(getDocumentFolderId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>webcontentFolderId</column-name><column-value><![CDATA[");
        sb.append(getWebcontentFolderId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>vocabularyId</column-name><column-value><![CDATA[");
        sb.append(getVocabularyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>period</column-name><column-value><![CDATA[");
        sb.append(getPeriod());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>clamavServerIP</column-name><column-value><![CDATA[");
        sb.append(getClamavServerIP());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>clamavPort</column-name><column-value><![CDATA[");
        sb.append(getClamavPort());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
