package be.sdlg.webapps.model;

import java.util.List;

public class CohortRange extends Predecent {


	public Long id;
	public Long cohortId;
	public Integer begin;
	public Integer end;

	
	// transient
	public Cohort cohort;
	public CohortRange(List<StudyEventDef> studyEventDefs) {
		super(studyEventDefs);
		// TODO Auto-generated constructor stub
	}

	
}
