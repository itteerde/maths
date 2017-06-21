package de.itter.maths.discrete;

import java.util.Collection;
import java.util.TreeSet;

public class SimpleTreeNode implements TreeNode {

	private TreeNode parent = null;
	private Collection<TreeNode> children = new TreeSet<TreeNode>();
	private Object content;
	private int depth;

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public SimpleTreeNode(TreeNode parent) {
		this.parent = parent;
	}

	public TreeNode getParent() {

		return parent;
	}

	public void addChild(TreeNode child) {
		children.add(child);
		child.setParent(this);
	}

	@Override
	public void setParent(TreeNode parent) {
		this.parent = parent;

	}
}
