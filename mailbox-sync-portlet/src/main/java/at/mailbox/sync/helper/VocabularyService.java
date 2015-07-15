package at.mailbox.sync.helper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

@ManagedBean(name = "vocabularyService")
@ApplicationScoped
public class VocabularyService {

	private List<AssetVocabulary> getAllVocabularies() {
		List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
		List<AssetVocabulary> vocabulariesFiltered = new ArrayList<AssetVocabulary>();
		try {
			int count = AssetVocabularyLocalServiceUtil
					.getAssetVocabulariesCount();
			vocabularies = AssetVocabularyLocalServiceUtil
					.getAssetVocabularies(0, count);
			for (AssetVocabulary vocabulary : vocabularies) {
				long groupId = vocabulary.getGroupId();
				if(groupId==getCurrentGroupId() || groupId==getGlobalGroupId())
					vocabulariesFiltered.add(vocabulary);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return vocabulariesFiltered;
	}

	private long getCurrentGroupId() {
		FacesContext context = FacesContext.getCurrentInstance();
		ThemeDisplay themeDisplay = (ThemeDisplay) context.getExternalContext()
				.getRequestMap().get(WebKeys.THEME_DISPLAY);
		return themeDisplay.getLayout().getGroupId();
	}
	
	private long getGlobalGroupId() {
		Company company;
		long groupId = 0;
		try {
			company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			groupId = company.getGroup().getGroupId(); 
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  groupId;
	}
	
	public List<AssetVocabulary> getVocabularies() {
        return getAllVocabularies();
    } 
}
