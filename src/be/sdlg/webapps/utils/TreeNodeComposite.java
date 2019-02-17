package be.sdlg.webapps.utils;

import java.util.ArrayList;
import java.util.List;

import be.sdlg.webapps.model.ArmToSeg;


/* Composite à utiliser après le Build, pour effectuer des modification sur l'arbre */ 
public class TreeNodeComposite<T> {
	public List<TreeNode<T>> roots;
	public List<Object> iterator;
	
	private void recurAdd(TreeNode<T> t) {
		iterator.add(t.getItem());
		if (t.childs !=null) {
			for (TreeNode<T> c : t.childs) {
				recurAdd(c);
			}
		}
	}

	public TreeNodeComposite(TreeNodeBuilder<T> builder) {
		roots = builder.createTree();
		iterator = new ArrayList<Object>();
		for (TreeNode<T> t : roots) {
			recurAdd(t);
		}
	}
	public void addChild(TreeNode<T> parentNode, TreeNode<T> childNode) {
		//TODO: implements
	}
	public void removeChild(TreeNode<T> parentNode, TreeNode<T> childNode) {
		//TODO : implements
	}
		
	private String recurToString(TreeNode<T> t) {
		String s;
		s = t.toString()+'\n';
		if (t.childs !=null) {
			for (TreeNode<T> c : t.childs) {
				s=s+recurToString(c);
			}
		}
		return s;
		
	}
	public String toString() {
		String s="";
		for (TreeNode<T> t : roots) {
			s=s + recurToString(t);
		}
		return s;
	}
/* Template reccurence function to implement with details in the child class version*/
	/* The method applyEach must be customized and called with the proper parameters in each() and recurEach()
	 functions.
	 */
	/*	private void recurEach(TreeNode<T> t ) {
	
	}
	public void each( ) {
		for (TreeNode<T> t : roots) {
			recurEach(t) ;
		}
	}
	protected void applyEach() {
		
	}*/

}
