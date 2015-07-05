package at.mailbox.sync.model.impl;

import at.mailbox.sync.model.Mailbox;
import at.mailbox.sync.service.MailboxLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Mailbox service. Represents a row in the &quot;MailboxSync_Mailbox&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MailboxImpl}.
 * </p>
 *
 * @author Claus Reitmeier
 * @see MailboxImpl
 * @see at.mailbox.sync.model.Mailbox
 * @generated
 */
public abstract class MailboxBaseImpl extends MailboxModelImpl
    implements Mailbox {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a mailbox model instance should use the {@link Mailbox} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MailboxLocalServiceUtil.addMailbox(this);
        } else {
            MailboxLocalServiceUtil.updateMailbox(this);
        }
    }
}
