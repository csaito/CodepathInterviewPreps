//https://www.interviewbit.com/problems/wave-array/

public class Solution {
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
	    int intArray[] = new int[a.size()];
	    for (int i = 0; i < a.size(); i++) {
	        intArray[i] = a.get(i);
	    }
	    Arrays.sort(intArray);
	    for (int i = 0; i+1 < intArray.length; i=i+2) {
	       // swap int[n] with int[n+1] throughout
	       int first = intArray[i];
	       int second = intArray[i+1];
	       if (first != second) {
	           intArray[i] = second;
	           intArray[i+1] = first;
	       }     
	    }
	    return convertTo(intArray);
	}
	
	private ArrayList<Integer> convertTo(int[] array) {
	    ArrayList<Integer> returnValue= new ArrayList<Integer>();
	    for (int i = 0; i < array.length; i++) {
	        returnValue.add(array[i]);
	    }
	    return returnValue;
	}
}

/**

Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest. 
So, in example case, you will return [2, 1, 4, 3] 

**/
