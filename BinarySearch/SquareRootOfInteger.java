//https://www.interviewbit.com/problems/square-root-of-integer/

public class Solution {
	public int sqrt(int a) {
	    int low = 1; 
        int high = a;
        int smallest = 1;
        if (a == 0) {
            return 0;
        }
        while (low <= high) {
           int mid = low + ((high - low) / 2);
           long num = (long) mid * mid;
           if (num == a) {
               return mid;
           }
           if (num > a) {
               high = mid-1;
           } else { 
               smallest = mid;
               low = mid + 1;
           }
        }
        return smallest; 
	}
}

/**
Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
**/
