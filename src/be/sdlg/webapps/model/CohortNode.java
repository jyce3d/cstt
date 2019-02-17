package be.sdlg.webapps.model;

import be.sdlg.webapps.utils.TreeNode;

public class CohortNode extends TreeNode<CohortNode> {
	public Cohort cohort;
	public CohortNode(Cohort cohort) {
		this.cohort = cohort;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return cohort.id;
	}

	@Override
	public Long getParentId() {
		// TODO Auto-generated method stub
		return cohort.predecessorId;
	}

	public String toString() {
		return this.cohort.id+ " linked to " + this.cohort.code;

	}
	public Object getItem() {
		return  this.cohort;
	}

}
