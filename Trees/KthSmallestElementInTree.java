//https://www.interviewbit.com/problems/kth-smallest-element-in-tree/

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
    public int kthsmallest(TreeNode root, int k) {
        int left = treeNodeCount(root.left);
        if (left >= k) {
            return kthsmallest(root.left, k);
        } else if (left == (k-1)) {
            return root.val;
        } else {
            return kthsmallest(root.right, k-left-1);
        }
    }
    
    private int treeNodeCount(TreeNode a) {
        if (a == null) {
            return 0;
        } else {
            return treeNodeCount(a.left) + treeNodeCount(a.right) + 1;
        }
    }
}


/**
Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST 
**/
