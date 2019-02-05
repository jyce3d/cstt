package be.sdlg.webapps.model;

public class ArmToSeg {
	public Long studyId;
	public Long segmentId;
	public Long armId;
	public Float ratio;
	
	
	// Transient
	public Segment segment;
	public Arm arm;
	public Study study;
}
