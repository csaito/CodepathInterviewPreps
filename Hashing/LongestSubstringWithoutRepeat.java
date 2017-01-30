//https://www.interviewbit.com/problems/longest-substring-without-repeat/

public class Solution {
	public int lengthOfLongestSubstring(String a) {
	    if (a == null) {
	        return 0;
	    }
	    char[] charArray = a.toCharArray();
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    int start = 0;
	    int end = start+1;
	    int longest = 1;
	    map.put(charArray[start], 1);
	    while (end < charArray.length) {
	        if (!map.containsKey(charArray[end]) || map.get(charArray[end]) == 0) {
	            map.put(charArray[end], 1);
	            longest = Math.max(longest, end-start+1);
	        } else {
	            map.put(charArray[end], 2);
	            while (map.get(charArray[end]) > 1) {
	                int startItem = map.get(charArray[start]);
	                map.put(charArray[start], --startItem);
	                start++;
	            }
	        }
	        end = end+1;
	    }
	    return longest;
	}
}


/**
Given a string, 
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
**/
