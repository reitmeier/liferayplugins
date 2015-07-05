package at.mailbox.sync.service.persistence;

import at.mailbox.sync.model.Mailbox;
import at.mailbox.sync.service.MailboxLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Claus Reitmeier
 * @generated
 */
public abstract class MailboxActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public MailboxActionableDynamicQuery() throws SystemException {
        setBaseLocalService(MailboxLocalServiceUtil.getService());
        setClass(Mailbox.class);

        setClassLoader(at.mailbox.sync.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("mailboxId");
    }
}
