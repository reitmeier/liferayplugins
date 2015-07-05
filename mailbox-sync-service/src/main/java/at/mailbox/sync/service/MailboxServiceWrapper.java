package at.mailbox.sync.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MailboxService}.
 *
 * @author Claus Reitmeier
 * @see MailboxService
 * @generated
 */
public class MailboxServiceWrapper implements MailboxService,
    ServiceWrapper<MailboxService> {
    private MailboxService _mailboxService;

    public MailboxServiceWrapper(MailboxService mailboxService) {
        _mailboxService = mailboxService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _mailboxService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _mailboxService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _mailboxService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MailboxService getWrappedMailboxService() {
        return _mailboxService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMailboxService(MailboxService mailboxService) {
        _mailboxService = mailboxService;
    }

    @Override
    public MailboxService getWrappedService() {
        return _mailboxService;
    }

    @Override
    public void setWrappedService(MailboxService mailboxService) {
        _mailboxService = mailboxService;
    }
}
