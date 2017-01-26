//https://www.interviewbit.com/problems/colorful-number/

public class Solution {
	public int colorful(int a) {
	    int[] digitArray = new int[numlength(a)];
	    int num = a;
	    for (int i = digitArray.length-1; i >= 0; i--) {
	        digitArray[i] = num % 10;
	        num /= 10;
	    }
	    HashSet<Integer> colorfulNums = new HashSet<Integer>();
	    for (int i = 0; i < digitArray.length; i++) {
	        num = digitArray[i];	           
	        if (colorfulNums.contains(num)) {
	               return 0;
	        }
	        colorfulNums.add(num);
	        for (int j = i+1; j < digitArray.length; j++) {
	            num = num * digitArray[j];
	            if (colorfulNums.contains(num)) {
	                return 0;
	            }
	            colorfulNums.add(num);
	        }
	    }
	    return 1;
	}
	
	private int numlength(int num) {
        if (num == 0) {
            return 1;
        }
        int length;
        num = Math.abs(num);
        for (length=0; num>0; length++) {
            num = num/10;
        }
        return length;           
    }
}


/**

For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
**/

