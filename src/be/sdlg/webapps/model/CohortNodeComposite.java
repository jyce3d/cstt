package be.sdlg.webapps.model;

import java.util.List;

import be.sdlg.webapps.services.CohortNodeBuilder;
import be.sdlg.webapps.utils.TreeNode;
import be.sdlg.webapps.utils.TreeNodeComposite;

public class CohortNodeComposite extends TreeNodeComposite<CohortNode> {
	public CohortNodeComposite(CohortNodeBuilder builder ) {
		super(builder); 
	}


	
	public List<TreeNode<CohortNode>>  getTree() {
		return (List<TreeNode<CohortNode>>) roots;
	}
	
		

}
