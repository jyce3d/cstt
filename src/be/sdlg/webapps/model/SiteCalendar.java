package be.sdlg.webapps.model;

import java.util.Date;

public class SiteCalendar {
	public Long id;
	public Long siteId;
	public Date date;
	public Integer status;
	
	// transient
	public Site site;

}
