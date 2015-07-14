package at.mailbox.sync.helper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

@ManagedBean(name = "vocabularyService")
@ApplicationScoped
public class VocabularyService {

	/**
	 * reads all vocabularies with the current groupId
	 * @return 
	 */
	private List<AssetVocabulary> getAllVocabularies() {
		List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
		List<AssetVocabulary> vocabulariesFiltered = new ArrayList<AssetVocabulary>();
		try {
			long groupId = getCurrentGroupId();
			int count = AssetVocabularyLocalServiceUtil
					.getAssetVocabulariesCount();
			vocabularies = AssetVocabularyLocalServiceUtil
					.getAssetVocabularies(0, count);
			for (AssetVocabulary vocabulary : vocabularies) {
				if (groupId == vocabulary.getGroupId())
					vocabulariesFiltered.add(vocabulary);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return vocabulariesFiltered;
	}

	/**
	 * reads and returns the current groupId
	 * 
	 * @return curent groupId
	 */
	private long getCurrentGroupId() {
		FacesContext context = FacesContext.getCurrentInstance();
		ThemeDisplay themeDisplay = (ThemeDisplay) context.getExternalContext()
				.getRequestMap().get(WebKeys.THEME_DISPLAY);
		return themeDisplay.getLayout().getGroupId();
	}
	
	public List<AssetVocabulary> getVocabularies() {
        return getAllVocabularies();
    } 
}
