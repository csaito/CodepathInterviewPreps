//https://www.interviewbit.com/problems/largest-number/
public class Solution {
	// DO NOT MODIFY THE LIST
	public String largestNumber(final List<Integer> a) {
	
	    Comparator<Integer> comp = new Comparator<Integer>() {
	        public int compare(Integer x, Integer y) {
	             long first = Long.parseLong(x.toString() + y.toString());
	             long second = Long.parseLong(y.toString() + x.toString());
	             if (first < second) {
	                 return 1; 
	             } else if (first > second) {
	                 return -1;
	             } else {
	                 return 0;
	             }
	        }
	        public boolean equals(Object obj) {
	            return (obj == this);
	        }
	    };
	    
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    for (int i = 0; i < a.size(); i++) {
	        list.add(a.get(i));
	    }
	    Integer[] array = list.toArray(new Integer[list.size()]);
	    Arrays.sort(array, comp);
	    
	    StringBuffer buf = new StringBuffer();
	    
	    for (int i = 0; i < array.length; i++) {
	        buf.append(array[i].toString());
	    }
	    while (buf.charAt(0) == '0' && buf.length() > 1) {
	        buf.delete(0, 1);
	    }
	    return buf.toString();
	}
}

/**

Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

**/
