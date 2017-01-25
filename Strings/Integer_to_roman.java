// https://www.interviewbit.com/problems/integer-to-roman/

public class Solution {
	public String intToRoman(int a) {
	    
	    StringBuffer returnValue = new StringBuffer();
/**
I = 1	   
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000 **/	    
	    char[] romans = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
	    int thousands = a / 1000;
	    if (thousands > 0) {
	        for (int i = 0; i < thousands; i++) {
	            returnValue.append(romans[0]);
	        }
	    }
	    int hundreds = a / 100 % 10;
	    addValues(returnValue, hundreds, romans[0], romans[1], romans[2]);
	    int tens = a / 10 % 10;
	    addValues(returnValue, tens, romans[2], romans[3], romans[4]);
	    int ones = a % 10 ;
	    addValues(returnValue, ones, romans[4], romans[5], romans[6]);
	    
	    return returnValue.toString();
	    

	}
	private void addValues(StringBuffer buf, int i, char ten, char five, char one) {
	    switch (i)  {
	        case 1: buf.append(one); break;
	        case 2: buf.append(one).append(one); break;
	        case 3:  buf.append(one).append(one).append(one); break;
	        case 4:  buf.append(one).append(five); break;
	        case 5:  buf.append(five); break;
	        case 6:  buf.append(five).append(one); break;
	        case 7:  buf.append(five).append(one).append(one); break;
	        case 8:  buf.append(five).append(one).append(one).append(one); break;
	        case 9:  buf.append(one).append(ten); break;
	        default: break;
	    }
	}
}

/**
Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

Input is guaranteed to be within the range from 1 to 3999.

Example :

Input : 5
Return : "V"

Input : 14
Return : "XIV"
 Note : This question has a lot of scope of clarification from the interviewer. Please take a moment to think of all the needed clarifications and see the expected response using “See Expected Output” For the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed explanations. 

**/
