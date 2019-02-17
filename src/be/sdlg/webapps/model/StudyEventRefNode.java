package be.sdlg.webapps.model;

import java.util.List;

import be.sdlg.webapps.utils.TreeNode;

public class StudyEventRefNode extends TreeNode<StudyEventRefNode> {
	public StudyEventRef studyEventRef;
	public StudyEventRefNode(StudyEventRef sr) {
		this.studyEventRef =sr;
	}

	public Long getId() {
		
		return studyEventRef.id;
	}

	public Long getParentId() {
		// TODO Auto-generated method stub
		return studyEventRef.predecessorId;
	}

	public String toString() {
		return this.studyEventRef.id + " linked to " + this.studyEventRef.studyEventDefId;
	}
	public Object getItem() {
		return  this.studyEventRef;
	}
	
}
