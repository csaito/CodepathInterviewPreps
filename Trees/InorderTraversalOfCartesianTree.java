//https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/

public class Solution {
    public TreeNode buildTree(ArrayList<Integer> a) {
        if (a == null) {
            return null;
        }
        return makeMaxNode(0, a.size()-1, a);
    }
    
    private TreeNode makeMaxNode(int start, int end, ArrayList<Integer> a) {
        if (start > end) {
            return null;
        }
        int maxIndex = findMax(start, end, a);
        TreeNode returnValue = new TreeNode(a.get(maxIndex));
        returnValue.left = makeMaxNode(start, maxIndex-1, a);
        returnValue.right = makeMaxNode(maxIndex+1, end, a);
        
        return returnValue;
    }
    
    private int findMax(int start, int end, ArrayList<Integer> a) {
        int max = a.get(start);
        int maxIndex = start;
        for (int i = start+1; i <= end; i++) {
            int current = a.get(i);
            if (current > max) {
                max = current;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}


/**
Given an inorder traversal of a cartesian tree, construct the tree.

 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree. 
 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : [1 2 3]

Return :   
          3
         /
        2
       /
      1
**/
