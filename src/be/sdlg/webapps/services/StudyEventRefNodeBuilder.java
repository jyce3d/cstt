package be.sdlg.webapps.services;

import java.util.ArrayList;
import java.util.List;

import be.sdlg.webapps.model.StudyEventRef;
import be.sdlg.webapps.model.StudyEventRefNode;
import be.sdlg.webapps.utils.TreeNode;
import be.sdlg.webapps.utils.TreeNodeBuilder;

public class StudyEventRefNodeBuilder extends TreeNodeBuilder<StudyEventRefNode> {
	
	
	public StudyEventRefNodeBuilder (List<StudyEventRef> studyEventRefs) {

		 this.list = new ArrayList<TreeNode<StudyEventRefNode>>();
		 for (StudyEventRef sr : studyEventRefs) {
			 StudyEventRefNode srn = new StudyEventRefNode(sr);
			 this.list.add(srn);
		 }
	}
	@Override
	public List<TreeNode<StudyEventRefNode>> createTree() {
		// TODO Auto-generated method stub
		return super.createTree();
	}

}
