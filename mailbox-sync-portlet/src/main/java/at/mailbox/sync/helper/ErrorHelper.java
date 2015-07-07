package at.mailbox.sync.helper;

import java.text.MessageFormat;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import at.mailbox.sync.exceptions.MailboxUserSecretException;

import com.liferay.portal.UserEmailAddressException;

public class ErrorHelper {

	/**
	 *	Report multiple messages.
	 * @param severity severtity
	 * @param properties ressourcename of textmapping
	 * @param errormsg errormessage
	 * @param params parameters for errormessage
	 * @param errorIds errorIds
	 * @return false
	 */
	public static void reportParamMessage(Severity severity, String properties, String errormsg, Object[] params, String... errorIds) {
		FacesContext context = FacesContext.getCurrentInstance();
		String errMsg = context.getApplication().getResourceBundle(context, properties).getString(errormsg);
		if (params != null) {
			for (int i = 0; i < params.length; ++i) {
				errMsg = errMsg.replace("%" + i, String.valueOf(params[i]));
			}
		}
		for (int i = 0; i < errorIds.length; ++i) {
			context.addMessage(errorIds[i], new FacesMessage(severity, errMsg, errMsg));
		}
	}

	public static void reportGlobalMessage(Severity severity, String properties, String errormsg) {
		FacesContext context = FacesContext.getCurrentInstance();
		String errMsg = context.getApplication().getResourceBundle(context, properties).getString(errormsg);
		context.validationFailed();
		context.addMessage(null, new FacesMessage(severity, errMsg, errMsg));
	}

	public static void reportGlobalMessageWithParameter(Severity severity, String properties, String errormsg, Integer param) {
		Object params[] = new Integer[1];
        FacesContext context = FacesContext.getCurrentInstance();
        String errMsg = context.getApplication().getResourceBundle(context,properties).getString(errormsg);

        if (param != null && param>0) 
        	params[0] = param;
        else 
        	params[0] = 100;
        MessageFormat mf = new MessageFormat(errMsg);
        errMsg = mf.format(params, new StringBuffer(), null).toString();
		context.validationFailed();
		context.addMessage(null, new FacesMessage(severity, errMsg, errMsg));
    }

	public static void reportGlobalMessageWithParameter(Severity severity, String properties, String errormsg, Object[] param) {
        FacesContext context = FacesContext.getCurrentInstance();
        String errMsg = context.getApplication().getResourceBundle(context,properties).getString(errormsg);

        MessageFormat mf = new MessageFormat(errMsg);
        errMsg = mf.format(param, new StringBuffer(), null).toString();
		context.validationFailed();
		context.addMessage(null, new FacesMessage(severity, errMsg, errMsg));
    }	
	
	public static void reportGlobalMessage(Severity severity, Exception ex) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.validationFailed();
		String errMsg=null;
		
		if (ex instanceof UserEmailAddressException) {
			errMsg = context.getApplication().getResourceBundle(context, "msg_communication").getString("please-enter-a-valid-email-address");	
		}
		if (ex instanceof MailboxUserSecretException) {
			errMsg = context.getApplication().getResourceBundle(context, "msg_communication").getString("please-enter-a-valid-user-secret");	
		}

		
		if (errMsg==null) {
			errMsg= ex.getClass().getName();
		}
		context.addMessage(null, new FacesMessage(severity, errMsg, errMsg));
		
	}
	
}
