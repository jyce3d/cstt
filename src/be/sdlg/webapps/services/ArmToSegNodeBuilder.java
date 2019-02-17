package be.sdlg.webapps.services;

import java.util.List;

import be.sdlg.webapps.model.ArmToSeg;
import be.sdlg.webapps.model.ArmToSegNode;
import be.sdlg.webapps.utils.TreeNode;
import be.sdlg.webapps.utils.TreeNodeBuilder;

public class ArmToSegNodeBuilder extends TreeNodeBuilder<ArmToSegNode> {
	public ArmToSegNodeBuilder (List<ArmToSeg> armToSegs) {
		for (ArmToSeg as : armToSegs) {
			ArmToSegNode asn = new ArmToSegNode(as);
			list.add(asn);
		}
	}
	@Override
	public List<TreeNode<ArmToSegNode>> createTree() {
		// TODO Auto-generated method stub
		return super.createTree();
	}
}
