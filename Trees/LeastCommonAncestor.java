//https://www.interviewbit.com/problems/least-common-ancestor/


public class Solution {
	public int lca(TreeNode a, int val1, int val2) {
	   ArrayList<TreeNode> path1 =  findPathTo(a, val1, new ArrayList<TreeNode>());
	   ArrayList<TreeNode> path2 =  findPathTo(a, val2, new ArrayList<TreeNode>());
	   
	   if (path1 == null || path2 == null) {
	       // not found
	       return -1;
	   } 
	   int i = path1.size() - 1;
	   int j = path2.size() - 1;
	   int lastVal = -1;
	   while (i >= 0 && j >= 0) {
	       TreeNode a1 = path1.get(i);
	       TreeNode a2 = path2.get(j);
	       if (a1.val != a2.val) {
	           break;
	       } else {
	           lastVal = a1.val;
	       }
	       i--;
	       j--;
	   }
	    
	   return lastVal;
	}
	
	ArrayList<TreeNode> findPathTo(TreeNode a, int val, ArrayList<TreeNode> path) {
	    if (a == null) {
	        return null;
	    } else {
	        path.add(0, a);
	        if (a.val == val) { // found
	            return path;
	        } else {
	            ArrayList<TreeNode> leftPath = findPathTo(a.left, val, new ArrayList<TreeNode>(path));
	            if (leftPath != null) {
	                return leftPath;
	            }
	            ArrayList<TreeNode> rightPath = findPathTo(a.right, val, new ArrayList<TreeNode>(path));
	            if (rightPath != null) {
	                return rightPath;
	            }
	        }
	    }
	    return null; // not found
	}
}

/**
Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
**/
