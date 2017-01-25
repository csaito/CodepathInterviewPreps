//https://www.interviewbit.com/problems/reverse-the-string/

public class Solution {
	public String reverseWords(String a) {
	    String[] results = a.split("\\s");
	    StringBuffer buf = new StringBuffer();
	    for (int i = results.length; i > 0; i--) {
	        String str = results[i-1];
	        if (str.length() > 0) {	           
	           if (buf.length() > 0) {
	              buf.append(' ');
	           }
	           buf.append(str);
	        }
	    }
	    return buf.toString();
	}
}


/**
Given an input string, reverse the string word by word.

Example:

Given s = "the sky is blue",

return "blue is sky the".

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.
**/
