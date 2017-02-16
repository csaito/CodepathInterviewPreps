//https://www.interviewbit.com/problems/gray-code/

public class Solution {
	public ArrayList<Integer> grayCode(int a) {
	    return generateGrayCode(a);
	}
	
	ArrayList<Integer> generateGrayCode(int a) {
	    ArrayList<Integer> returnValue = new ArrayList<Integer>();
	    if (a == 0) {
	        // nothing to add
	    } else if (a == 1) {
	        returnValue.add(0);
	        returnValue.add(1);
	    } else {
	        int targetNum = getTwoPower(a);
	        //System.out.println("targetNum for " + a + " is " + targetNum);
	        ArrayList<Integer> previousList = generateGrayCode(a-1);
	        returnValue.addAll(previousList);
	        Collections.reverse(previousList);
	        //returnValue.add(targetNum);
	        for (int i = 0; i < previousList.size(); i++) {
	            returnValue.add(previousList.get(i) + targetNum);
	        }
	    }
	    return returnValue;
	}
	
	HashMap<Integer, Integer> powers = new HashMap<Integer, Integer>();
	int getTwoPower(int a) {
	    if (a <= 1) {
	        return 1;
	    }
	    if (!powers.containsKey(a)) {
	        powers.put(a, getTwoPower(a-1) * 2);
	    }
	    return powers.get(a);
	}
}

/**
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
There might be multiple gray code sequences possible for a given n.
Return any such sequence.
**/
