// https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
public class Solution {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
	    if (a.size() == 0) {
	        return -1000000000;
	    }
	    int max = a.get(0);
	    int finalMax = max;
	    for (int i = 1; i < a.size(); i++) {
	        int num = a.get(i);
	        max = Math.max(num, (num+max));
	        finalMax = Math.max(finalMax, max);
	    }
	    return finalMax;
	}
}


/**
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.

**/
