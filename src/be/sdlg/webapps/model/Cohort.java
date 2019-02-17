package be.sdlg.webapps.model;

import java.util.List;

public class Cohort extends Predecent {
	public Cohort(List<StudyEventDef> studyEventDefs) {
		super(studyEventDefs);
	}
	public Long id;
	public Long armToSegId;
	public Long studyId;
	public String code;
	public String Description;
	public Long predecessorId;
	
	// Transient
//	public Cohort predecessor;
	public ArmToSeg armToSeg;
//	public List<Cohort> successorList;
	public List<CohortRange> rangeList;
	public Study study;

}
