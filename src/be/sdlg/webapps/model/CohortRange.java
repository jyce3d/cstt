package be.sdlg.webapps.model;

public class CohortRange {
	public Long id;
	public Long cohortId;
	public Integer begin;
	public Integer end;
	public Float interval;
	public Long afterEventId;
	public Long targetEventId;
	
	// transient
	public Cohort cohort;
	public StudyEventDef afterEvent;
	public StudyEventDef targetEvent;
	
}
