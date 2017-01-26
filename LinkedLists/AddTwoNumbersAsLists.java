//https://www.interviewbit.com/problems/add-two-numbers-as-lists/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    
	    ListNode returnValue = new ListNode(0);
	    ListNode ptr = returnValue;
	    
        while (a != null || b != null) {
	        int a1 = getDigit(a);
	        int b1 = getDigit(b);
	        int sum = a1 + b1 + ptr.val;
	        
	        int carryover = sum / 10;
	        int lastDigitSum = sum % 10;
	        
	        ptr.val = lastDigitSum;
	        
	        if (a != null) a = a.next;
	        if (b != null) b = b.next;
	        
	        if (a != null || b != null || carryover != 0) {
	            ptr.next = new ListNode(carryover);
	        }
	        ptr = ptr.next;
	    }
	    
	    return returnValue;
	}
	
	int getDigit(ListNode a) {
	    return (a == null) ? 0 : a.val;
	}
}

/**
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
**/
