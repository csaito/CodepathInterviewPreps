//https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/

public class Solution {
	public TreeNode sortedArrayToBST(final List<Integer> a) {
	    return sortedArrayToBSTWithRange(a, 0, a.size() - 1);
	}
	
	private TreeNode sortedArrayToBSTWithRange(final List<Integer> a, int l, int h) {
	    if (l > h) {
	        return null;
	    }
	    int mid = l + (h-l)/2;
	    int num = a.get(mid);
	    
	    TreeNode node = new TreeNode(num);
	    node.left = sortedArrayToBSTWithRange(a, l, mid-1);
	    node.right = sortedArrayToBSTWithRange(a, mid+1, h);
	    return node;  
	}
}

/**
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : [1, 2, 3]
A height balanced BST  : 

      2
    /   \
   1     3

**/
