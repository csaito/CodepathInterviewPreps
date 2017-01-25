// https://www.interviewbit.com/problems/compare-version-numbers/


public class Solution {
	public int compareVersion(String a, String b) {
	    if (a == null || b == null) {
	        return 0; // undetermined - probably should throw error
	    }
	    String pattern = "\\.";
	    String[] a1 = a.split(pattern);
	    String[] b1 = b.split(pattern);
	    int maxLength = Math.max(a1.length, b1.length);
	    for (int i = 0; i < maxLength; i++) {
	        String a2 = (i < a1.length) ? a1[i] : "";
	        String b2 = (i < b1.length) ? b1[i] : "";
	        int diff = compareStrings(a2, b2);
	        if (diff != 0) {
	            return diff;
	        }
	    }
	    return 0;
	}
	private int compareStrings(String a2, String b2) {
	    StringBuffer buf1 = new StringBuffer(a2.replaceFirst("^0+", ""));
	    StringBuffer buf2 = new StringBuffer(b2.replaceFirst("^0+", ""));
	    if (buf1.length() > buf2.length()) {
	        return 1;
	    } else if (buf1.length() < buf2.length()) {
	        return -1;
	    } else {
	        for (int i = 0; i < buf1.length(); i++) {
	            char a = buf1.charAt(i);
	            char b = buf2.charAt(i);
	            if (a != b) {
	                return (a > b) ? 1 : -1;
	            }
	        }
	    }
	    return 0;
	}
}

/**
Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
**/
