package be.sdlg.webapps.model;

import java.util.List;

public class Predecent {
	public Float interval;
	public Long  predecessorId;
	public Long afterEventId;
	public Long targetEventId;
	public StudyEventDef afterEvent;
	public StudyEventDef targetEvent;
	
	public Predecent(List<StudyEventDef> studyEventDefs) {
		assignStudyEventDef(studyEventDefs);
	}
	public void assignStudyEventDef(List<StudyEventDef> studyEventDefs) {
		for (StudyEventDef sd : studyEventDefs) {
			if (afterEventId.equals(sd.id)) {
				afterEvent = sd;
			} else if (targetEventId.equals(sd.id))
				targetEvent =sd;
		}
	}
}
