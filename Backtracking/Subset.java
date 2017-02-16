//https://www.interviewbit.com/problems/subset/

public class Solution {
    
    HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
    
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {

        int[] flags = new int[a.size()];
        
        Collections.sort(a);
	    
        backtrack(flags, 0, flags.length, a.toArray(new Integer[0]));
        
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
        
        ArrayList<ArrayList<Integer>> returnValue = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> subset : hashSet) {
            returnValue.add(subset);
        }
        
        Collections.sort(returnValue, comp);
	    
	    return returnValue;
	}
	
    public void processSolution(int[] flags, Integer[] S){
        //System.out.print("Adding ");
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0; i<S.length; i++){
            if(flags[i] == 1){
                temp.add(S[i]);
                //System.out.print(S[i] + ", ");
            }
        }
        //System.out.println("");
        hashSet.add(temp);
    }
     
    public void backtrack(int[] flags, int k, int n, Integer[] S){
        if (k == n){
            processSolution(flags, S);
        } else {
            flags[k] = 0;
            backtrack(flags, k+1, n, S);
            flags[k] = 1;
            backtrack(flags, k+1, n, S);
        }
    }

}

/**
Given a set of distinct integers, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
**/
