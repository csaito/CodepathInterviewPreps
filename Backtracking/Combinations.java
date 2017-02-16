//https://www.interviewbit.com/problems/combinations/

public class Solution {
	HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
	
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    int[] a = new int[n];
	    for (int i = 0; i < a.length; i++) {
	        a[i] = (i+1);
	    }

	    boolean[] flags = new boolean[a.length];
	    
	    backtrack(a, flags, k, 0, new ArrayList<Integer>()); 
	    
	    ArrayList<ArrayList<Integer>> returnValue = new ArrayList<ArrayList<Integer>>();
	    for (ArrayList<Integer> set: hashSet) {
	        returnValue.add(set);
	    }
	    Comparator<ArrayList<Integer>> comp = new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int sizeA = a.size();
                int sizeB = b.size();
                for (int i = 0; i < sizeA; i++) {
                    if (sizeB <= i) {
                        return 1;
                    }
                    int numA = a.get(i);
                    int numB = b.get(i);
                    if (numA < numB) {
                        return -1;
                    } 
                    if (numA > numB) {
                        return 1;
                    }
                }
                return new Integer(sizeA).compareTo(sizeB);
            }
        };
        Collections.sort(returnValue, comp);
	    return returnValue;
	}
	
	private void recordResult(ArrayList<Integer> tmp) {
	    hashSet.add(new ArrayList<Integer>(tmp));
	}
	
	private void backtrack(int[] a, boolean[] flags, int k, int currentIndex, ArrayList<Integer> tmp) {
	    if (tmp.size() == k) {
	        recordResult(tmp);
	        return;
	    }
	    
	    for (int i = currentIndex; i < a.length; i++) {
	        tmp.add(a[i]);
	        backtrack(a, flags, k, i+1, tmp);
	        tmp.remove(tmp.size() - 1);
	        backtrack(a, flags, k, i+1, tmp);
	    }
	}
}

/**
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,
1. Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
2. Entries should be sorted within themselves.

Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
**/
