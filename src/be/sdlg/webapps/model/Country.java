package be.sdlg.webapps.model;

import java.util.List;

public class Country {
	public Long id;
	public String code;
	public String label;
	
	public List<CountryCalendar> countryCalendars;
}
