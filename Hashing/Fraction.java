//https://www.interviewbit.com/problems/fraction 

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
	    StringBuffer buf = new StringBuffer();
	    if (denominator == 0) {
	        return "Invalid test case";
	    } else if (numerator == 0) {
	        return "0";
	    } else {
	        if (numerator < 0) {
	            if (denominator > 0) {
	                buf.append("-");
	            } 
	        } else if (denominator < 0) {
	            buf.append("-");
	        }
	        
	        long div = Math.abs((long)numerator) / Math.abs((long)denominator);
	        long rem = Math.abs((long)numerator) % Math.abs((long)denominator);
	        //System.out.println("first div, rem " +  div + ", " + rem);
	        buf.append(div);
	        if (rem != 0) {
	            buf.append(".");
	            HashMap<Long, Integer> records = new HashMap<Long, Integer>();
	            StringBuffer fraction = new StringBuffer();
	            int index = 0;
	            records.put(rem, index);
	            while (rem > 0) {
	                Long toDivide = rem * 10;
	                div = toDivide / denominator;
	                rem = toDivide % denominator;
	                //stem.out.println("div=" + div + ", rem=" + rem);
	                fraction.append(Math.abs(div));
	                index++;
	                if (records.containsKey(rem)) {
	                    char beginBracket = '(';
	                    int offsetIndex = records.get(rem);
	                    fraction = fraction.insert(offsetIndex, beginBracket);
	                    fraction.append(')');
	                    break;
	                } else {
	                    //System.out.println("appending " + Math.abs(div));
	                    records.put(rem, index);
	                }
	            }
	            //System.out.println("fraction=" + fraction + ", rem=" + rem);
	            buf.append(fraction.toString());
	        }
	    }
	    return buf.toString();
	}
}	


/**
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"

**/
