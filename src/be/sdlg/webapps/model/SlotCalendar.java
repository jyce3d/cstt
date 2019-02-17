package be.sdlg.webapps.model;

import java.util.List;

public class SlotCalendar {
	public Long id;
	public Long siteCalendarId;
	public Long studyEventInstId;
	public Long siteRefId;
	// transient
	public StudyEventInst studyEventInst;
	public SiteRef siteRef;
}
