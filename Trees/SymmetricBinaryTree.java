//https://www.interviewbit.com/problems/symmetric-binary-tree/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int isSymmetric(TreeNode a) {
	    if (a == null) return 1;
	    
	    if (a.left == null || a.right == null) {
	        return (a.left == a.right) ? 1 : 0 ;
	    }
	    
	    
	    // trying iterative solution.
	    ArrayDeque<TreeNode> treeA = new ArrayDeque<TreeNode>();
	    ArrayDeque<TreeNode> treeB = new ArrayDeque<TreeNode>();

	    treeA.add(a.left);
	    treeB.add(a.right);
	    
	    while (!treeA.isEmpty() && !treeB.isEmpty()) {
	        TreeNode nodeA = treeA.removeFirst();
	        TreeNode nodeB = treeB.removeFirst();
	        
	        if (nodeA.val != nodeB.val) {
	            return 0;
	        }
	        if (nodeA.left == null) {
	            if (nodeB.right != null) {
	                return 0;
	            }
	        }
	        if (nodeA.right == null) {
	            if (nodeB.left != null) {
	                return 0;
	            }
	        }
	        if (nodeB.left == null) {
	            if (nodeA.right != null) {
	                return 0;
	            }
	        }
	        if (nodeB.right == null) {
	            if (nodeA.left != null) {
	                return 0;
	            }
	        }
	        if (nodeA.left != null) {
	            treeA.addFirst(nodeA.left);
	            treeB.addFirst(nodeB.right);
	        }
	        if (nodeA.right != null) {
	            treeA.addFirst(nodeA.right);
	            treeB.addFirst(nodeB.left);	        
	        }
	    }
	    
	    return (treeA.isEmpty() && treeB.isEmpty()) ? 1 : 0;
	}
    
    boolean areTwoSymmetric(TreeNode a, TreeNode b) {
       
        if (a == null || b == null) {
            return (a == b);
        } else {
            //System.out.println("Comparing " + a.val + ", " + b.val);
            return ((a.val == b.val) && 
                 areTwoSymmetric(a.left, b.right) &&
                 areTwoSymmetric(a.right, b.left));
        }
        
        
    }
}
/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric. 
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
**/
