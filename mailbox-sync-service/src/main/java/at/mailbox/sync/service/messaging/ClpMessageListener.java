package at.mailbox.sync.service.messaging;

import at.mailbox.sync.service.ClpSerializer;
import at.mailbox.sync.service.MailboxLocalServiceUtil;
import at.mailbox.sync.service.MailboxServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            MailboxLocalServiceUtil.clearService();

            MailboxServiceUtil.clearService();
        }
    }
}
