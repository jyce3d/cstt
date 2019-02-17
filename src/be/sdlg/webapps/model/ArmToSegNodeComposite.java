package be.sdlg.webapps.model;

import java.util.List;

import be.sdlg.webapps.services.ArmToSegNodeBuilder;
import be.sdlg.webapps.utils.TreeNode;
import be.sdlg.webapps.utils.TreeNodeComposite;

public class ArmToSegNodeComposite extends TreeNodeComposite<ArmToSegNode> {
	public ArmToSegNodeComposite(ArmToSegNodeBuilder builder ) {
		//List<TreeNode<StudyEventRefNode>> 
		super(builder);
	}

	public List<TreeNode<ArmToSegNode>>  getTree() {
		return (List<TreeNode<ArmToSegNode>>) roots;
	}
}
