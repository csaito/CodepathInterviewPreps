//https://www.interviewbit.com/problems/palindrome-partitioning/

public class Solution {
    ArrayList<ArrayList<String>> returnValue = new ArrayList<ArrayList<String>>();
    
	public ArrayList<ArrayList<String>> partition(String a) {
	    findPali(a, 0, new StringBuffer(), new ArrayList<String>());
	    return returnValue;
	}
	
	private void findPali(String a, int index, StringBuffer tmpBuffer, ArrayList<String> tmp) {
	    if (index == a.length()) {
	        if (tmpBuffer.length() == 0) {
	            addResult(tmp);
	        }
	        return;
	    }
	    tmpBuffer.append(a.charAt(index));
	    String curStr = tmpBuffer.toString();
	    if (isPali(curStr)) {
	        tmp.add(curStr);
	        findPali(a, index+1, new StringBuffer(), tmp);
	        tmp.remove(tmp.size()-1);
	    } 
	    findPali(a, index+1, tmpBuffer, tmp);
	}
	
	private boolean isPali(String s) {
	    return s.equals(new StringBuilder(s).reverse().toString());
	}
	
	private void addResult(ArrayList<String> tmp) {
	    returnValue.add(new ArrayList<String>(tmp));
	    /**
	    System.out.print("Added ");
	    for (int i = 0; i < tmp.size(); i++) {
	        System.out.print(tmp.get(i) + ", ");
	    }
	    System.out.println();
	    **/
	}
	
		Comparator<ArrayList<String>> comp = new Comparator<ArrayList<String>>() {
            public int compare(ArrayList<String> a, ArrayList<String> b) {
                int sizeA = a.size();
                int sizeB = b.size();
                for (int i = 0; i < sizeA; i++) {
                    if (sizeB <= i) {
                        return 1;
                    }
                    int lenA = a.get(i).length();
                    int lenB = b.get(i).length();
                    if (lenA < lenB) {
                        return -1;
                    } 
                    if (lenA > lenB) {
                        return 1;
                    }
                }
                return new Integer(sizeA).compareTo(sizeB);
            }
        };
}


/**
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
 Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
*
*
*
(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
In the given example,
["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
**/


