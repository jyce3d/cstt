package be.sdlg.webapps.services;

import java.util.Map;

import be.sdlg.webapps.model.Study;

public interface CsttSrvc {
	public Study createStudy(Long studyId, Map<String, Integer> params);

}
