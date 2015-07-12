/**
 * 
 */
package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

import at.mailbox.sync.exceptions.MailboxUserSecretException;
import at.mailbox.sync.helper.ErrorHelper;
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
public class AdminBean {

	
	private ServiceContext serviceContext = null;
	private int tabViewIndex =0;
	
		public int getTabViewIndex() {
		return tabViewIndex;
	}
	public void setTabViewIndex(int tabViewIndex) {
		this.tabViewIndex = tabViewIndex;
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
	
	
}
