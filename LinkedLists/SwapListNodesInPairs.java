//https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/

public class Solution {
	public ListNode swapPairs(ListNode a) {
	    ListNode head = swapTwoNodes(a);
	    ListNode tail = head;
	    while (tail != null && tail.next != null) {
	        tail = tail.next;
	        ListNode swapped = swapTwoNodes(tail.next);
	        tail.next = swapped;
	        tail = tail.next;
	    }
	    return head;
	}
	
	private ListNode swapTwoNodes(ListNode first) {
	    ListNode returnValue = first;
	    if (first != null && first.next != null) {
	        ListNode second = first.next;
	        //System.out.println("Swapping " + first.val + " and " + second.val);
	        first.next = second.next;
	        second.next = first;
	        returnValue = second;
	    }
	    return returnValue;
	}
}

/**
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
**/
