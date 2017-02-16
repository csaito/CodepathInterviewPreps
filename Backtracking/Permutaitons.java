//https://www.interviewbit.com/problems/permutations/

public class Solution {
    private boolean [] flag;
    private ArrayList<ArrayList<Integer>> res;
    private ArrayList<Integer> A;

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

	    this.flag = new boolean[A.size()];
	    this.res  = new ArrayList<>();
	    this.A    = A;

	    rec(0, new ArrayList<>());

	    return res;
	}

	public void rec(int index, ArrayList<Integer> temp) {

	    if (index == flag.length) {
	        res.add(new ArrayList<>(temp));
	        return;
	    }

	    for (int i = 0; i < flag.length; i++) {
	        if (!flag[i]) {
	            flag[i] = true;
	            temp.add(A.get(i));
	            rec(index + 1, temp);
	            flag[i] = false;
	            temp.remove(temp.size() - 1);
	        }
	    }


	}
}


/**
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]
 NOTE
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 
**/
