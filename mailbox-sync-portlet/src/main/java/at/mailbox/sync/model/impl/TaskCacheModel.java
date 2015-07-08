package at.mailbox.sync.model.impl;

import at.mailbox.sync.model.Task;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Task in entity cache.
 *
 * @author Claus Reitmeier
 * @see Task
 * @generated
 */
public class TaskCacheModel implements CacheModel<Task>, Externalizable {
    public long taskId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String status;
    public String description;
    public long mailboxId;
    public long permissionUserGroupId;
    public long eventCalendarId;
    public long documentFolderId;
    public long webcontentFolderId;
    public long vocabularyId;
    public long period;
    public String clamavServerIP;
    public int clamavPort;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(37);

        sb.append("{taskId=");
        sb.append(taskId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", status=");
        sb.append(status);
        sb.append(", description=");
        sb.append(description);
        sb.append(", mailboxId=");
        sb.append(mailboxId);
        sb.append(", permissionUserGroupId=");
        sb.append(permissionUserGroupId);
        sb.append(", eventCalendarId=");
        sb.append(eventCalendarId);
        sb.append(", documentFolderId=");
        sb.append(documentFolderId);
        sb.append(", webcontentFolderId=");
        sb.append(webcontentFolderId);
        sb.append(", vocabularyId=");
        sb.append(vocabularyId);
        sb.append(", period=");
        sb.append(period);
        sb.append(", clamavServerIP=");
        sb.append(clamavServerIP);
        sb.append(", clamavPort=");
        sb.append(clamavPort);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Task toEntityModel() {
        TaskImpl taskImpl = new TaskImpl();

        taskImpl.setTaskId(taskId);
        taskImpl.setGroupId(groupId);
        taskImpl.setCompanyId(companyId);
        taskImpl.setUserId(userId);

        if (userName == null) {
            taskImpl.setUserName(StringPool.BLANK);
        } else {
            taskImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            taskImpl.setCreateDate(null);
        } else {
            taskImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            taskImpl.setModifiedDate(null);
        } else {
            taskImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (status == null) {
            taskImpl.setStatus(StringPool.BLANK);
        } else {
            taskImpl.setStatus(status);
        }

        if (description == null) {
            taskImpl.setDescription(StringPool.BLANK);
        } else {
            taskImpl.setDescription(description);
        }

        taskImpl.setMailboxId(mailboxId);
        taskImpl.setPermissionUserGroupId(permissionUserGroupId);
        taskImpl.setEventCalendarId(eventCalendarId);
        taskImpl.setDocumentFolderId(documentFolderId);
        taskImpl.setWebcontentFolderId(webcontentFolderId);
        taskImpl.setVocabularyId(vocabularyId);
        taskImpl.setPeriod(period);

        if (clamavServerIP == null) {
            taskImpl.setClamavServerIP(StringPool.BLANK);
        } else {
            taskImpl.setClamavServerIP(clamavServerIP);
        }

        taskImpl.setClamavPort(clamavPort);

        taskImpl.resetOriginalValues();

        return taskImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        taskId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        status = objectInput.readUTF();
        description = objectInput.readUTF();
        mailboxId = objectInput.readLong();
        permissionUserGroupId = objectInput.readLong();
        eventCalendarId = objectInput.readLong();
        documentFolderId = objectInput.readLong();
        webcontentFolderId = objectInput.readLong();
        vocabularyId = objectInput.readLong();
        period = objectInput.readLong();
        clamavServerIP = objectInput.readUTF();
        clamavPort = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(taskId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (status == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(status);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(mailboxId);
        objectOutput.writeLong(permissionUserGroupId);
        objectOutput.writeLong(eventCalendarId);
        objectOutput.writeLong(documentFolderId);
        objectOutput.writeLong(webcontentFolderId);
        objectOutput.writeLong(vocabularyId);
        objectOutput.writeLong(period);

        if (clamavServerIP == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(clamavServerIP);
        }

        objectOutput.writeInt(clamavPort);
    }
}
