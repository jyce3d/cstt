package be.sdlg.webapps.model;

public class ArmToSeg {
	public Long id;
	public Long studyId;
	public Long segmentId;
	public Long armId;
	public Float ratio;
	public Long predecessorId;
	
	// Transient
	public Segment segment;
	public Arm arm;
	public Study study;
	public ArmToSeg predecessor;
	public CohortNodeComposite cohorts;
	public Float curRatio; //used to determine if we reach the ratio during assingnment 
}
