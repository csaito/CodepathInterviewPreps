//https://www.interviewbit.com/problems/implement-strstr/
public class Solution {
	public int strStr(final String haystack, final String needle) {
	    if (haystack == null || needle == null) {
	        return -1;
	    }
	    char[] haystackC = haystack.toCharArray();
	    char[] needleC = needle.toCharArray();
	    int[] indexTable = createIndexTable(needleC);
	    
	    int needleIndex = 0;
	    
	    for (int i = 0; i < haystackC.length; i++) {
	        if (haystackC[i] == needleC[needleIndex]) {
	            needleIndex++;
	            if (needleIndex == needleC.length) {
	                return i - needleIndex + 1;
	            }
	        } else {
	            needleIndex = indexTable[needleIndex];
	            if (haystackC[i] == needleC[needleIndex]) {
	                needleIndex++;
	            }
	        }
	    }
	    return -1;
	}
	
	private int[] createIndexTable(char[] needleC) {
	    int[] returnValue = new int[needleC.length];
	    returnValue[0] = 0;
	    //System.out.print(returnValue[0] + " ");
	    for (int i = 1; i < needleC.length; i++) {
	        if (i == 1){
	            returnValue[i] = 0;
	        } else {
	            int previousIndex = returnValue[i-1];
	            if (needleC[i-1] == needleC[previousIndex]) {
	                returnValue[i] = previousIndex+1;
	            } else {
	                returnValue[i] = 0;
	            }
	        }
	        //System.out.print(returnValue[i] + " ");
	    }
	    //System.out.println();
	    return returnValue;
	}
}

/**
Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ). 
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases. 
**/
