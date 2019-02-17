package be.sdlg.webapps.services;

import be.sdlg.webapps.model.CohortNode;

import java.util.List;

import be.sdlg.webapps.model.Cohort;
import be.sdlg.webapps.utils.TreeNode;
import be.sdlg.webapps.utils.TreeNodeBuilder;


public class CohortNodeBuilder extends TreeNodeBuilder<CohortNode> {

	public CohortNodeBuilder (List<Cohort> cohorts) {
		for (Cohort c : cohorts) {
			CohortNode cn = new CohortNode(c);
			list.add(cn);
		}
	}
	@Override
	public List<TreeNode<CohortNode>> createTree() {
		// TODO Auto-generated method stub
		return super.createTree();
	}
}
