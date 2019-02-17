package be.sdlg.webapps.model;

import java.util.List;

public class Patient {
	public Long id;
	public Long studyId;
	public Long cohortId;
	public Long siteId;
	public String code;
	public Long createSeq;
	public Long status;
	
	// transient
	public Study study;
	public Cohort cohort;
	public Site site;
	public List<StudyEventInst> studyEventInsts;	
	
}
