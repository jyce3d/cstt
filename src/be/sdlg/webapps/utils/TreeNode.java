package be.sdlg.webapps.utils;

import java.util.List;

public abstract class TreeNode<T> {
	public TreeNode<T> parent;
	public List<TreeNode<T>> childs;
	public abstract Long getId();
	public abstract Long getParentId();
	public String toString() {
		return "not initialized";
	}
	public abstract Object getItem();
}
