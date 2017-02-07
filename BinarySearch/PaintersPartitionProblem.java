//https://www.interviewbit.com/problems/painters-partition-problem/

public class Solution {
	public int paint(int a, int b, ArrayList<Integer> c) {
	    int totalBoard = 0;
	    for (int i = 0; i < c.size(); i++) {
	        totalBoard += c.get(i);
	    }
	    int l = 0; 
	    int h = totalBoard;
	    long possibleTime = totalBoard * b;
	    while (l <= h) {
	        int mid = l + (h-l)/2;
	        if (isPossible(a, b, c, (long)mid*b)) {
	            possibleTime = (long)mid*b;	    
	            //System.out.println("possibleTime updated " + possibleTime);
	            h = mid-1;
	        } else {
	            l = mid+1;
	        }
	    }
	    return (int) (possibleTime % 10000003);
	}
	
	boolean isPossible(int a, int b, ArrayList<Integer> c, long time) {

	    int painters = 1;
	    long painterTime = 0;
	    for (int i = 0; i < c.size(); i++) {
	        int board = c.get(i);
	        long boardTime = (long) board * b;
	        if (boardTime > time) {
	            //System.out.println("single board exceeds, returning false");
	            return false;
	        }
	        painterTime += boardTime;
	        if (painterTime > time) {
	            painters++;
	            if (painters > a) {
	                //System.out.println("no more painters, returning false");
	                return false;
	            }
	            painterTime = boardTime;
	        } 
	    }
	    //System.out.println("Possible, returning true.");
	    return true;
	}
}


/**
You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.
Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board

Output:
     return minimum time to paint all boards % 10000003
Example

Input : 
  K : 2
  T : 5
  L : [1, 10]
Output : 50
**/

