package be.sdlg.webapps.model;

import java.util.List;

public class Segment extends Predecent {
	public Segment(List<StudyEventDef> studyEventDefs) {
		super(studyEventDefs);
	}


	public Long id;
	public String segmentCode;
	public String segmentDescription;
	public Long predecessorId;

	
	// transient
	public ArmToSegNodeComposite armToSegs;
	
}
