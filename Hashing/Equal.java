// https://www.interviewbit.com/problems/equal/

public class Solution {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        HashMap<Integer, IndexPair> sumHash = new HashMap<Integer, IndexPair>();
        Indices smallestIndice = null;
        
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                IndexPair previous = sumHash.get(sum);
                if (previous != null) {
                    Indices newIndice = new Indices(previous, new IndexPair(i,j));
                    if (newIndice.isValid()) {
                        if (newIndice.isSmaller(smallestIndice)) {
                            //System.out.println("Swapping smallest with " + newIndice);
                            smallestIndice = newIndice;
                        }
                    }
                    //System.out.println("Compairing " + newIndice + " with " + smallestIndice);

                } else {
                    sumHash.put(sum, new IndexPair(i,j));
                }
            }
        }
        ArrayList<Integer> returnValue = new ArrayList<Integer>();
        if (smallestIndice != null) {
            returnValue.add(smallestIndice.a.i);
            returnValue.add(smallestIndice.a.j);
            returnValue.add(smallestIndice.b.i);
            returnValue.add(smallestIndice.b.j);
        }
        return returnValue;
    }
    
    class IndexPair {
        int i = 0;
        int j = 0;
        IndexPair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public String toString() {
            return "[" + i + ", " + j + "]";
        }
    }
    
    class Indices {
        IndexPair a;
        IndexPair b;
        Indices(IndexPair a, IndexPair b) {
            this.a = a;
            this.b = b;
        }
        boolean isValid() {
            return (a.i < b.i && a.j != b.i && a.j != b.j);
        }
        boolean isSmaller(Indices otherPair) {
            if (otherPair == null) {
                return true;
            }
            if (this.a.i != otherPair.a.i) {
                return this.a.i < otherPair.a.i;
            } else if (this.a.j != otherPair.a.j) {
                return this.a.j < otherPair.a.j;
            } else if (this.b.i != otherPair.b.i) {
                return this.b.i < otherPair.b.i;
            } else {
                return this.b.j < otherPair.b.j;
            }
        }        
        public String toString() {
            return "(" + a + " " + b + ")";
        }
    }
    
}


/**
Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

Note:

1) Return the indices `A1 B1 C1 D1`, so that 
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1 

2) If there are more than one solutions, 
   then return the tuple of values which are lexicographical smallest. 

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )  
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
If no solution is possible, return an empty list.

**/
