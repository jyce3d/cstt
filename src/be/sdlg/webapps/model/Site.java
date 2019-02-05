package be.sdlg.webapps.model;

public class Site {
	public Long id;
	public Long countryId;
	public Long typeId;
	public String code;
	public String label;
// Transient
	public Country country;
}
