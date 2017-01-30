//https://www.interviewbit.com/problems/window-string/

public class Solution {
	public String minWindow(String S, String T) {
	    if (S == null || T == null || T.length() == 0) {
	        return "";
	    }
	    
	    HashMap<Character, Integer> targets = new HashMap<Character, Integer>();
	    HashMap<Character, Integer> found = new HashMap<Character, Integer>();
	    char[] s = S.toCharArray();
	    char[] t = T.toCharArray();
	    for (int i = 0; i < t.length; i++) {
	        incrementValue(targets, t[i]);
	    }
	    int start = 0;
	    int end = 0;
	    
	    int foundIndex = -1;
	    int shortest = s.length;
	    int foundItemCount = 0;
	    
	    while (end < s.length) {
	        //System.out.println("checking " + s[end] + " for end " + end);
	        if (targets.containsKey(s[end])) {
	            incrementValue(found, s[end]);
	            if (found.get(s[end]) <= targets.get(s[end])) {
	                foundItemCount++;
	            }
	            while (foundItemCount == t.length) {
	                // window found
	                //System.out.println("window found, start, end = " + start + ", " + end);
	                int length = end-start+1;
	                //System.out.println("length = " + length + ", shortest " + shortest);
	                if (shortest > length || foundIndex == -1) {
	                    shortest = length;
	                    foundIndex = start;
	                } 
	                // increment start	        
	                if (targets.containsKey(s[start])) {
                        decrementValue(found, s[start]);
                        if (!found.containsKey(s[start]) || found.get(s[start]) < targets.get(s[start])) {
                            foundItemCount--;
                        }
                    } 
	                start++;
	            } 
	        }
	        end++;
	    }
	    String returnValue = "";
	    if (foundIndex >= 0) {
	        returnValue = S.substring(foundIndex, foundIndex + shortest);
	    }
	    return returnValue;
	}
	
	void incrementValue(HashMap<Character, Integer> map, char target) {
	    if (map.containsKey(target)) {
            int newValue = map.get(target) + 1;
            map.put(target, newValue);
	    } else {
	        map.put(target, 1);
	    }
	}
	void decrementValue(HashMap<Character, Integer> map, char target) {
	    if (map.containsKey(target)) {
            int newValue = map.get(target) - 1;
            if (newValue == 0) {
                map.remove(target);
            } else {
                map.put(target, newValue);
	        } 
	    }
	}
}


/**
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
**/
