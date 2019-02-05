package be.sdlg.webapps.model;

import java.util.List;

public class Cohort {
	public Long id;
	public Long armToSegId;
	public Long studyId;
	public String code;
	public String Description;
	public Long predecessorId;
	public Float bcInterval;
	public Long bcAfterEventId;
	public Long bcTargetEventId;
	
	// Transient
	public Cohort predecessor;
	public ArmToSeg armToSeg;
	public List<Cohort> successorList;
	public List<CohortRange> rangeList;
	public Study study;
	public StudyEventDef bcAfterEvent;
	public StudyEventDef bcTargetEvent;
}
