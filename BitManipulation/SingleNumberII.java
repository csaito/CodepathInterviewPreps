//https://www.interviewbit.com/problems/single-number-ii/

public class Solution {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
	    int bitmask = 0;
	    int ones = 0;
	    int twos = 0;
            Integer[] arr = a.toArray(new Integer[a.size()]);
            for (int i = 0; i < arr.length; i++) {
                twos = twos | (ones & arr[i]); 
                ones = ones ^ arr[i]; 
                bitmask = ~(ones & twos); 
                ones &= bitmask; // this erases the third one
                twos &= bitmask; // this erases the third one
            }
     
            return ones;
	}
}


/**
Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4
**/

