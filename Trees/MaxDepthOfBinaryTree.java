//https://www.interviewbit.com/problems/max-depth-of-binary-tree/

public class Solution {
	public int maxDepth(TreeNode a) {
	    ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
	    int depth = 0;
	    if (a == null) {
	        return 0;
	    }
	    nodes.add(a);
	    while (!nodes.isEmpty()) {
	        depth++; 
	        ArrayList<TreeNode> children = new ArrayList<TreeNode>();
	        for (int i = 0; i < nodes.size(); i++) {
	            TreeNode node = nodes.get(i);
	            if (node.left != null) children.add(node.left);
	            if (node.right != null) children.add(node.right);
	        }
	        nodes = children;
	    }
	    
	    return depth;
	}
}


/**
Given a binary tree, find its maximum depth.

The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
**/
