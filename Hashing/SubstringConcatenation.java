//https://www.interviewbit.com/problems/substring-concatenation/

public class Solution {
	public ArrayList<Integer> findSubstring(String a, final List<String> b) {
	    ArrayList<Integer> returnValue = new ArrayList<Integer>();
	    if (a == null || b.size() == 0) {
	        return returnValue;
	    }
	    
	    int strSize = b.get(0).length() * b.size();
	    int startIndex = 0;
	    int endIndex = startIndex + strSize;
	    
	    while (endIndex <= a.length()) {
	        String substr = a.substring(startIndex, endIndex);
	        if (isSubstring(substr, b)) {
	            returnValue.add(startIndex);
	        }
	        startIndex++;
	        endIndex++;
	    }
	    return returnValue;
	}
	
	private boolean isSubstring(String a, final List<String> b) {
	    String str = a;
	    ArrayList<String> list = new ArrayList<String>(b);
	    int strSize = list.get(0).length();
	    while (str.length() > 0) {
	        String top = str.substring(0, strSize);
	        //System.out.println("Checking " + top + " from " + str);
	        if (list.contains(top)) {
	            list.remove(top);
	            str = str.substring(strSize, str.length());
	        } else {
	            return false;
	        }
	    }
	    return list.isEmpty();
	}
}

/**
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
**/
