package be.sdlg.webapps.model;

import java.util.List;

public class Site {
	public Long id;
	public Long countryId;
	public Long typeId;
	public String code;
	public String label;
// Transient
	public Country country;
	
	public List<WeeklyCalendar> weeklyCalendars;
	public List<SiteCalendar> siteCalendars;
}
