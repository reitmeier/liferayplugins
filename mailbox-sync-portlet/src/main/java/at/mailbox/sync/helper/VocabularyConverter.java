package at.mailbox.sync.helper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.liferay.portlet.asset.model.AssetVocabulary;
 
@FacesConverter("vocabularyConverter")
public class VocabularyConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                VocabularyService service = (VocabularyService) fc.getExternalContext().getApplicationMap().get("vocabularyService");
                List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
                vocabularies = service.getVocabularies();
                for(AssetVocabulary vocabulary : vocabularies){
                	if(vocabulary.getPrimaryKey()==Long.parseLong(value))
                		return vocabulary;
                }
                return null; 
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid vocabulary."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((AssetVocabulary) object).getPrimaryKey());
        }
        else {
            return null;
        }
    }   
}         
