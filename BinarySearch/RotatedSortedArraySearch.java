//https://www.interviewbit.com/problems/rotated-sorted-array-search/

public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> a, int b) {
	    
	    // first find pivot
	    int pivotIndex = -1;
	    int l = 0;
	    int h = a.size() - 1;
	    while (l <= h) {
	        int mid = l + ((h-l)/2);
	        int num = a.get(mid);
	        int preIndex = (mid == 0) ? a.size() - 1 : mid - 1;
	        int preNum = a.get(preIndex);
	        if (preNum > num) {
	            pivotIndex = mid;
	            break;
	        } else {
	            int last = a.get(h);
	            if (last > num) {
	                h = mid - 1;
	            } else {
	                l = mid + 1;
	            }
	        }
	    }
	    if (pivotIndex == -1 || a.get(pivotIndex) > b) {
	        return -1;
	    }
	    
	    if (a.get(pivotIndex) == b) {
	        return pivotIndex;
	    }
	    
	    //System.out.println("pivotIndex " + pivotIndex);
	    
	    int last = a.get(a.size() - 1);
	    if (last == b) {
	        return a.size() - 1;
	    } else if (last < b) {
	        l = 0;
	        h = pivotIndex - 1;
	    } else {
	        l = pivotIndex + 1;
	        h = a.size() - 1;
	    }
	    
		while (l <= h) {
	        int mid = l + ((h-l)/2);
	        int num = a.get(mid);
	        if (num == b) {
	            return mid;
	        } else if (num < b) {
	            l = mid + 1;
	        } else {
	            h = mid - 1;
	        }
	    }    
	    
	    return -1;
	}
}

/**

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*

**/
