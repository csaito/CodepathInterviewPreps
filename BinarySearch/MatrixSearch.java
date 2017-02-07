//https://www.interviewbit.com/problems/matrix-search/

public class Solution {
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    ArrayList<Integer> firstRow = a.get(0);
	    int rowCount = a.size();
	    int columnCount = firstRow.size();
	    int totalItems = rowCount * columnCount;
	    
	    int l = 0;
	    int h = totalItems - 1;
	    while (l <= h) {
	        //System.out.print("low, high " + l + ", " + h);
	        int mid = l + (h-l)/2;
	        
	        int row = mid / columnCount;
	        int column = mid % columnCount;
	        int val = a.get(row).get(column);
	        //System.out.println(" val " + val);
	        if (val == b) {
	            return 1;
	        } else if (val < b) {
	            l = mid + 1;
	        } else {
	            h = mid - 1;
	        }
	    }
	    
	    return 0;
	}
}


/**
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
**/
