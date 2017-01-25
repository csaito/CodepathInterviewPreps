//https://www.interviewbit.com/problems/pascal-triangle-rows/

public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    
	    int[] previous = new int[0];
	    int[] current = new int[0];
	    
	    ArrayList<ArrayList<Integer>> returnValue = new ArrayList<ArrayList<Integer>>();
	    
	    for (int i = 0; i < a; i++) {
	        current = new int[i+1];
	        for (int j = 0; j <= i; j++) {
	            // insert elements
	            int num = 1;
	            if (j > 0 && j < i) {
	                num = previous[j-1] + previous[j];
	            }
	            current[j] = num;
	        }
	        previous = current;
	        returnValue.add(convertToArrayList(current));
	    }
	    
	    return returnValue;
	}
	
	private ArrayList<Integer> convertToArrayList(int[] array) {
	   ArrayList<Integer> returnValue = new ArrayList<Integer>();
	   for (int i = 0; i < array.length; i++) {
	       returnValue.add(array[i]);
	   }
	   return returnValue;
	}
}


/**

Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
**/
