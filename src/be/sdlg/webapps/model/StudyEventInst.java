package be.sdlg.webapps.model;

import java.util.Date;

public class StudyEventInst {
	public Long id;
	public Long patientId;
	public Long StudyId;
	public Date baseline;
	public Date forecast;
	public Date actual;
	public Date estimated;
	
	// Transient
	public Patient patient;
	public Study study;
}
