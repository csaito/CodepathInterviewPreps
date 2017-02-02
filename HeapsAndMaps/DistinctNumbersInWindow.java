//https://www.interviewbit.com/problems/distinct-numbers-in-window/

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) { 
        ArrayList<Integer> returnValue = new  ArrayList<Integer>();
        HashMap<Integer, Integer> records = new HashMap<Integer, Integer>();
        if(A.size() < B) {
            return returnValue;
        }
        int count = 0;
        for (int i = 0; i < B; i++) {
            int item = A.get(i);
            increment(records, item);
            int itemCount = records.get(item);
            if (itemCount == 1) {
                count++;
            } 
        }
        //System.out.println("Adding " + count);
        returnValue.add(count);
        
        int offset = 0;
        while ((offset + B) < A.size()) {
            int firstItem = A.get(offset);
            int lastItem = A.get(offset+B);
            if (firstItem != lastItem) {
                decrement(records, firstItem);
                increment(records, lastItem);
                if (!records.containsKey(firstItem)) {
                    count--;
                } 
                int lastItemCount = records.get(lastItem);
                if (lastItemCount == 1) {
                    count++;
                } 
            }
            //System.out.println("Adding " + count);
            returnValue.add(count);
            offset = offset + 1;
        }
        
        return returnValue;
    }
    
    private void increment(HashMap<Integer, Integer> map, int item) {
        //System.out.println("increment " + item);
        if (map.containsKey(item)) {
            int count = map.get(item);
            map.put(item, count+1);
        } else {
            map.put(item, 1);
        }
    }
    private void decrement(HashMap<Integer, Integer> map, int item) {
        //System.out.println("decrement " + item);
        if (map.containsKey(item)) {
            int newCount = map.get(item) - 1;
            if (newCount > 0) {
                map.put(item, newCount);
            } else {
                map.remove(item);
            }
        } 
    }
}

/**

You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:
- If K > N, return empty array.

For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].
**/
