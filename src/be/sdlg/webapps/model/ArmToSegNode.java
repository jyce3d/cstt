package be.sdlg.webapps.model;

import be.sdlg.webapps.utils.TreeNode;

public class ArmToSegNode extends TreeNode<ArmToSegNode> {
	public ArmToSeg armToSeg;
	
	public ArmToSegNode (ArmToSeg as) {
		this.armToSeg = as;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return armToSeg.id;
	}

	@Override
	public Long getParentId() {
		// TODO Auto-generated method stub
		return armToSeg.predecessorId;
	}
	public Object getItem() {
		return  this.armToSeg;
	}

}
