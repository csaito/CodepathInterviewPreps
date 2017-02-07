//https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-postorder/


public class Solution {
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
	    return buildTreeWithList(inorder, postorder);
	}
	
	private TreeNode buildTreeWithList(List<Integer> inorder, List<Integer> postorder) {
	    if (inorder.size() == 0 || postorder.size() == 0) {
	        return null;
	    }   
	    
	    int root = postorder.get(postorder.size()-1);
	    TreeNode rootNode = new TreeNode(root);
	    
	    int size = inorder.size();
	    for (int i = 0; i < size; i++) {
	        if (inorder.get(i) == root) {
	            int mid = i;
	            rootNode.left = buildTreeWithList(inorder.subList(0, mid), postorder.subList(0, mid));
	            rootNode.right = buildTreeWithList(inorder.subList(mid+1, size), postorder.subList(mid, size-1));
	            break;
	        }
	    }
	    return rootNode;
	}
}

/**

Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : 
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

Return : 
            1
           / \
          2   3

**/
