package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

import at.mailbox.sync.helper.ErrorHelper;
import at.mailbox.sync.model.Mailbox;
import at.mailbox.sync.model.Task;
import at.mailbox.sync.service.MailboxLocalServiceUtil;
import at.mailbox.sync.service.TaskLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

@ManagedBean
@SessionScoped
public class TaskAdminBean {
	private long NEWID=0;
	private ServiceContext serviceContext = null;
	private Task selectedTask = null;
	private Mailbox selectedMailbox = null;
	public Mailbox getSelectedMailbox() {
		return selectedMailbox;
	}
	public void setSelectedMailbox(Mailbox selectedMailbox) {
		this.selectedMailbox = selectedMailbox;
	}
	public Task getSelectedTask() {
		return selectedTask;
	}
	public void setSelectedTask(Task selectedTask) throws SystemException {
		this.selectedTask = selectedTask;
		this.setSelectedMailbox(MailboxLocalServiceUtil.fetchMailbox(this.selectedTask.getMailboxId()));
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
	
	}
	public List<Task> getTaskList () {
		try {
			return  TaskLocalServiceUtil.getTaskByGroupId(serviceContext.getScopeGroupId());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Task>();
		}
	}
	public String addTask() throws SystemException {
		long taskId=NEWID;
		Task newTask=TaskLocalServiceUtil.createTask(taskId);
		this.setSelectedTask(newTask);
		return "ADD_TASK";
		
	}
	public boolean isNewTask() {
		if (selectedTask!=null && selectedTask.getTaskId()==NEWID) {
			return true;
		} else {
			return false;
		}
	}
	private boolean validateTask() throws Exception{
		
		return true;
	}
	public String saveTask() {
		try {
			validateTask();	
		}catch (Exception ex) {
			ErrorHelper.reportGlobalMessage(FacesMessage.SEVERITY_ERROR, ex);
			return "SAVEERROR";
		}
		
		if (isNewTask()) {
			long userId = serviceContext.getUserId();
			long groupId = serviceContext.getScopeGroupId();
			try {
				String description = selectedTask.getDescription();
				Long mailboxId = selectedMailbox!=null ? selectedMailbox.getMailboxId() : null;
		        Long permissionUserGroupId = selectedTask.getPermissionUserGroupId();
		        Long eventCalendarId = selectedTask.getEventCalendarId();
		        Long documentFolderId = selectedTask.getDocumentFolderId();
		        Long webcontentFolderId = selectedTask.getWebcontentFolderId();
		        Long vocabularyId = selectedTask.getVocabularyId();
		        Long period= selectedTask.getPeriod();
		        String clamavServerIP = selectedTask.getClamavServerIP();
		        Integer clamavPort = selectedTask.getClamavPort();
				selectedTask=TaskLocalServiceUtil.addTask(userId,groupId,description,mailboxId,permissionUserGroupId, eventCalendarId,documentFolderId,webcontentFolderId,vocabularyId,period,clamavServerIP,clamavPort,serviceContext);	
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
				selectedTask.setMailboxId(selectedMailbox!=null ? selectedMailbox.getMailboxId() : null);
				selectedTask=TaskLocalServiceUtil.updateTask(selectedTask);
				return "SAVEOK";
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "SAVEERROR";
		
	}
	
	public String deleteTask() {
		try {
			TaskLocalServiceUtil.deleteTask(selectedTask);
			return "DELETEOK";
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "DELETEERROR";
	}
	
	public List<Mailbox> completeMailboxes(String query) throws SystemException {
        List<Mailbox> allMailboxes = MailboxLocalServiceUtil.getMailboxByGroupId(serviceContext.getScopeGroupId());
        List<Mailbox> filteredMailboxes = new ArrayList<Mailbox>();
         
        for (int i = 0; i < allMailboxes.size(); i++) {
            Mailbox test = allMailboxes.get(i);
            if(test.getDescription().toLowerCase().startsWith(query)) {
            	filteredMailboxes.add(test);
            }
        }
         
        return filteredMailboxes;
    }
	 public char getMailboxGroup(Mailbox mailbox) {
	        return mailbox.getDescription().charAt(0);
	}
}
