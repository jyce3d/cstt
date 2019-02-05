package be.sdlg.webapps.model;

public class StudyEventRef {
	public Long id;
	public Long studyId;
	public Long cohortId;
	public Long studyEventDefId;
	public Long predecessorId;
	public Long siteId;
	public Long studyEventModelRefId;
	public Float interval;
	public Float tolLow;
	public Float tolUp;
	// Transient
	public Study study;
	public StudyEventDef studyEventDef;
	public StudyEventRef predecessor;
	public Site site;
	public StudyEventRefModel studyEventRefModel;
}
