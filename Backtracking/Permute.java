//https://www.interviewbit.com/problems/permutations/

public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> returnValue = new ArrayList<ArrayList<Integer>>();
	    if (a.size() == 0) {
	        return null;
	    } else if (a.size() == 1) {
	        returnValue.add(a);
	    } else {
	        int firstItem = a.remove(0);
	        ArrayList<ArrayList<Integer>> previous = permute(a);
	        for (int i = 0; i < previous.size(); i++) {
	            ArrayList<Integer> list = previous.get(i);
	            list.add(0, firstItem);
	            returnValue.add(list);
	            for (int j = 1; j < list.size(); j++) {
	                int currentItem = list.get(j);
	                if (currentItem != firstItem) {
	                    ArrayList<Integer> newList = new ArrayList<Integer>(list);
	                    newList.set(0, currentItem);
	                    newList.set(j, firstItem);
	                    if (!returnValue.contains(newList)) {
	                        returnValue.add(newList);
	                    }
	                }
	            }
	        }
	    }
	    //for (int count = 0; count < returnValue.size(); count++) {
	    //    System.out.println(count + " : arrayItem " + returnValue.get(count));
	    //}
	    return returnValue;
	}
	
}
