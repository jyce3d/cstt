package be.sdlg.webapps.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeBuilder<T> {
	protected List<TreeNode<T>> list;
	public List<TreeNode<T>> roots;
	public TreeNodeBuilder() {
		roots = new ArrayList<TreeNode<T>>();
		list = new ArrayList<TreeNode<T>>();
	}
	private void recur(TreeNode<T> node) {
		for (TreeNode<T> n : list) {
			if (n.getParentId().equals(node.getId())) {
				if (node.childs ==null)
					node.childs =  new ArrayList<TreeNode<T>>();
				node.childs.add(n);
				n.parent = node;
			}
				
		}
	}
	// return roots
	public List<TreeNode<T>> createTree() {
		for (TreeNode<T> t : list) {
			if (t.parent == null ) 
				roots.add(t);
		}
		for (TreeNode<T> r : roots) {
			recur(r); 
		}
		return roots;
	}
	
}
