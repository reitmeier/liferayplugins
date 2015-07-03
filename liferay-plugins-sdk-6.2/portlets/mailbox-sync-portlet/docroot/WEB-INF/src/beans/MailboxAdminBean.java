/**
 * 
 */
package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.portlet.PortletRequest;

import at.mailbox.sync.model.Mailbox;
import at.mailbox.sync.service.MailboxLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

/**
 * @author Claus Reitmeier
 * first collaboration test
 */
@ManagedBean
@SessionScoped
public class MailboxAdminBean {

	private List<Mailbox> mailboxList = null;
	private ServiceContext serviceContext = null;
	private Mailbox selectedMailbox = null;
	private long NEWMAILBOXID=0;
	public Mailbox getSelectedMailbox() {
		return selectedMailbox;
	}
	public void setSelectedMailbox(Mailbox selectedMailbox) {
		this.selectedMailbox = selectedMailbox;
	}
	private ServiceContext getServiceContext() throws PortalException, SystemException {
		if (serviceContext==null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			PortletRequest portletRequest = (PortletRequest) facesContext.getExternalContext().getRequest();
			
			serviceContext=  ServiceContextFactory.getInstance( Mailbox.class.getName(), portletRequest);
		}
		return serviceContext;
		
		
	}
	@PostConstruct
	public void init() {
		long groupId;
		try {
			getServiceContext();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//List<Mailbox> mailboxList= MailboxLocalServiceUtil.getMailboxByGroupId(serviceContext.getScopeGroupId());
	}
	
	public String addMailbox() {
		long mailboxId=NEWMAILBOXID;
		Mailbox newMailbox=MailboxLocalServiceUtil.createMailbox(mailboxId);
		this.setSelectedMailbox(newMailbox);
		return "ADD";
		
	}
	
	public boolean isNewMailbox() {
		if (selectedMailbox!=null && selectedMailbox.getMailboxId()==NEWMAILBOXID) {
			return true;
		} else {
			return false;
		}
	}
	
	public String saveMailbox() {
		if (isNewMailbox()) {
			long userId = serviceContext.getUserId();
			long groupId = serviceContext.getScopeGroupId();
			try {
				selectedMailbox=MailboxLocalServiceUtil.addMailbox(userId, groupId, selectedMailbox.getDescription(), selectedMailbox.getHost(), selectedMailbox.getPort(), selectedMailbox.getMailboxUser(), selectedMailbox.getMailboxUserSecret(), serviceContext);
				return "SAVEOK";
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			try {
				selectedMailbox=MailboxLocalServiceUtil.updateMailbox(selectedMailbox);
				return "SAVEOK";
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "SAVEERROR";
		
	}
	
	public String deleteMailbox() {
		try {
			MailboxLocalServiceUtil.deleteMailbox(selectedMailbox);
			return "DELETEOK";
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "DELETEERROR";
	}
	
	public String test(ActionEvent actionEvent) throws PortalException, SystemException {
	
		MailboxLocalServiceUtil.addMailbox(serviceContext.getUserId(), serviceContext.getScopeGroupId(), "description", "host", 1, "mailboxUser", "mailboxUserSecret", serviceContext);
		return "OK";
	}
	
	public List<Mailbox> getMailboxList () {
		try {
			return  MailboxLocalServiceUtil.getMailboxByGroupId(serviceContext.getScopeGroupId());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Mailbox>();
		}
	}
	
	
}
