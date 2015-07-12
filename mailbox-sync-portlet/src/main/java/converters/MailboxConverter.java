package converters;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import at.mailbox.sync.model.Mailbox;
import at.mailbox.sync.service.MailboxLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
@FacesConverter("mailboxConverter")
public class MailboxConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		// TODO Auto-generated method stub
		if(value != null && value.trim().length() > 0) {
            try {
                return MailboxLocalServiceUtil.getMaibox(Long.parseLong(value));
            } catch(NumberFormatException e) {
            	//e.printStackTrace();
            } catch (PortalException e) {				
            	//e.printStackTrace();		
			} catch (SystemException e) {
				//e.printStackTrace();
			}
            FacesContext context = FacesContext.getCurrentInstance();
            String summary = context.getApplication().getResourceBundle(context, "msg_communication").getString("not-a-valid-mailbox");	
		
            String detail =context.getApplication().getResourceBundle(context, "msg_communication").getString("the-selection-is-not-refering-to-a-valid-mailbox");	
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic1, Object object) {
		if(object != null) {
            return String.valueOf(((Mailbox) object).getMailboxId());
        }
        else {
            return null;
        }
	}

}
