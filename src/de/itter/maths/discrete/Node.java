package de.itter.maths.discrete;

import java.util.Set;

public interface Node {

	public Set<TreeNode> getPredecessors();

	public Set<TreeNode> getSuccessors();

}
