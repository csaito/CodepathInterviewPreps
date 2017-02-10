//https://www.interviewbit.com/problems/letter-phone/

public class Solution {
	public ArrayList<String> letterCombinations(String a) {
	    ArrayList<String> list = new ArrayList<String>();
	    
	    HashMap<Character, char[]> mapping = new HashMap<Character, char[]>();
	    
        char[] zero = {'0'};
        char[] one = {'1'};
        char[] two = {'a','b','c'};
        char[] three = {'d','e','f'};
        char[] four = {'g','h','i'};
        char[] five = {'j','k','l'};
        char[] six = {'m','n','o'};
        char[] seven = {'p','q','r', 's'};
        char[] eight = {'t','u','v'};
        char[] nine =  {'w','x','y','z'};
	    
	    mapping.put('0', zero);	    
	    mapping.put('1', one);    
	    mapping.put('2', two);    
	    mapping.put('3', three);    
	    mapping.put('4', four);    
	    mapping.put('5', five);    
	    mapping.put('6', six);    
	    mapping.put('7', seven);    
	    mapping.put('8', eight); 
	    mapping.put('9', nine);
	    
	    char[] input = a.toCharArray();
	    for (int i = 0; i < input.length; i++){
	        list = addPossibleCharsTo(list, mapping.get(input[i]));
	    }
	    return list;
	}
	
	private ArrayList<String> addPossibleCharsTo(ArrayList<String> prefix, 
	                                                char[] possibleChars) {
	    if (prefix == null || possibleChars == null) {
	        return prefix;
	    }
	    ArrayList<String> returnValue = new ArrayList<String>();
	    if (prefix.size() == 0) {
	        for (int i = 0; i < possibleChars.length; i++) {
	            returnValue.add(possibleChars[i] + "");
	        } 
	    } else {
	        for (int i = 0; i < prefix.size(); i++) {
	           for (int j = 0; j < possibleChars.length; j++) {
	               returnValue.add(prefix.get(i) + possibleChars[j]);
	           }
	        }
	    }
	    return returnValue;
	}
}
