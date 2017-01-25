// https://www.interviewbit.com/problems/longest-common-prefix/

public class Solution {
	public String longestCommonPrefix(ArrayList<String> a) {
	    int minLength = 0;
	    for (int i = 0; i < a.size(); i++) {
	        int size = a.get(i).length();
	        if (minLength == 0) {
	            minLength = size;
	        }
	        if (minLength > size) {
	            minLength = size;
	        }
	    }
	    StringBuffer buf = new StringBuffer();
	    for (int i = 0; i < minLength; i++) {
	        if (allEqualChar(a, i)) {
	            buf.append(a.get(0).charAt(i));
	        } else {
	            break;
	        }
	    }
	    return buf.toString();
	}
	
	private boolean allEqualChar(ArrayList<String> a, int index) {
	    char charToCheck = a.get(0).charAt(index); 
	    for (int i = 1; i < a.size(); i++) {
	        if (a.get(i).charAt(index) != charToCheck) {
	            return false;
	        }
	    }
	    return true;
	}
	
}

/**
Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.
**/
