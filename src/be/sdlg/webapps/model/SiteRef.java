package be.sdlg.webapps.model;

import java.util.List;

public class SiteRef {
	public Long id;
	public Long studyId;
	public Long siteId;
	
	// Transient
	public Site site;
	public Study study;
	public List<SlotCalendar> slotCalendars;
}
