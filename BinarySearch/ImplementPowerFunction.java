//https://www.interviewbit.com/problems/implement-power-function/

public class Solution {
	public int pow(int x, int n, int d) {
	    if (x == 0) {
	        return 0; 
	    }
	    if (n == 0) {
	        return 1;
	    }	    
	    int power = getPositiveModulo(x, d);
	    int y = 1;
	    while (n > 1) {
	       if (n % 2 == 1) {
	           y = getPositiveModulo((long)y * power, d);
	       }  
	       power = getPositiveModulo((long)power * power, d);
	       //System.out.print("power=" + power + ", n=" + n);
	       n = n / 2;
	       //System.out.println("n= " + n + ", y=" + y);
	    }
	    //System.out.println("power=" + power + ", y=" + y);
	    return getPositiveModulo((long)power * y, d);
	}
	
	private int getPositiveModulo(long x, int d) {
	    int returnValue = (int) (x % d);
	    if (returnValue < 0) {
	        returnValue += d;
	    }
	    return returnValue;
	}
}

/**

Implement pow(x, n) % d.

In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative. 
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.

**/
