//https://www.interviewbit.com/problems/search-for-a-range/

public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    ArrayList<Integer> returnValue = new ArrayList<Integer>();
	    
	    int low = 0; 
	    int high = a.size() -1;
	
	    // find first index
	    int firstIndex = -1;
	    while (low <= high) {
	        int mid = low + ((high-low)/2);
	        int num = a.get(mid);
	        if (num > b) {
	            high = mid - 1;
	        } else if (num < b) {
	            low = mid + 1;
	        } else {
	            firstIndex = mid;
	            high = mid - 1;
	        }
	    }
	    returnValue.add(firstIndex);
	    
	    // element not found 
	    if (firstIndex == -1) {
	        returnValue.add(-1);
	        return returnValue;
	    }
	    	    
	    // find last index
	    int lastIndex = firstIndex;
	    low = firstIndex + 1;
	    high = a.size() - 1;
	    while (low <= high) {
	        int mid = low + ((high-low)/2);
	        int num = a.get(mid);
	        if (num == b) {
	            lastIndex = mid;
	            low = mid + 1;
	        } else {
	            high = mid - 1;
	        }
	    }
	    
	    returnValue.add(lastIndex);
	    return returnValue;
	}
}

/**

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].

**/
