package be.sdlg.webapps.model;

import java.util.Date;

public class CountryCalendar {
	public Long id;
	public Long countryId;
	public String label;
	public Date closedDate;	
	// Transient
	public Country country;
	
}
