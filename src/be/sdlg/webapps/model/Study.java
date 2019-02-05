package be.sdlg.webapps.model;

import java.util.Date;

public class Study {
	public Long id;
	public String code;
	public String name;
	public String description;
	public Date startDate;
	
	// transient
	public Long patientCount;
	
}
