package be.sdlg.webapps.model;

import java.util.List;

import be.sdlg.webapps.services.StudyEventRefNodeBuilder;
import be.sdlg.webapps.utils.TreeNode;
import be.sdlg.webapps.utils.TreeNodeBuilder;
import be.sdlg.webapps.utils.TreeNodeComposite;

public class StudyEventRefComposite extends TreeNodeComposite<StudyEventRefNode> {

	public StudyEventRefComposite(TreeNodeBuilder<StudyEventRefNode> builder) {
			super(builder);
		// TODO Auto-generated constructor stub
		}

		@Override
		public void addChild(TreeNode<StudyEventRefNode> parentNode, TreeNode<StudyEventRefNode> childNode) {
			// TODO Auto-generated method stub
			super.addChild(parentNode, childNode);
		}

		@Override
		public void removeChild(TreeNode<StudyEventRefNode> parentNode, TreeNode<StudyEventRefNode> childNode) {
			// TODO Auto-generated method stub
			super.removeChild(parentNode, childNode);
		}
		
		public List<TreeNode<StudyEventRefNode>>  getTree() {
			return (List<TreeNode<StudyEventRefNode>>) roots;
		}
		
}
