package be.sdlg.webapps.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import be.sdlg.webapps.utils.TreeNodeComposite;

public class Study {
	public Long id;
	public String code;
	public String name;
	public String description;
	public Date startDate;
	
	// transient
	public Long patientCount;
	public List<SiteRef> sites;
	public StudyEventRefComposite studyEventRefs;
	public SegmentComposite segments;
	
	
}
