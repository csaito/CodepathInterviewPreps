//https://www.interviewbit.com/problems/reverse-bits/
public class Solution {
	public long reverse(long a) {
	    long returnValue = 0;
	    
	    for (int i = 0; i < 32; i++) {
	        returnValue <<= 1;
	        if ((a & (1 << i)) != 0)
	            returnValue |= 1;
	    }
	    
	    return returnValue;
	    
	}
}

/**
Reverse bits of an 32 bit unsigned integer

Example 1:

x = 0,

          00000000000000000000000000000000  
=>        00000000000000000000000000000000
return 0

Example 2:

x = 3,

          00000000000000000000000000000011 
=>        11000000000000000000000000000000
return 3221225472

Since java does not have unsigned int, use long
**/
