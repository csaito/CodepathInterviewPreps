// https://www.interviewbit.com/problems/insertion-sort-list/

public class Solution {
	public ListNode insertionSortList(ListNode a) {
	    if (a == null) {
	        return null;
	    }
	    ListNode sortedList = new ListNode(a.val);
	    
	    ListNode tail = a.next;
	    
	    while (tail != null) {
	        //System.out.println("inserting " + tail.val);
	        sortedList = insert(sortedList, tail.val);
	        tail = tail.next;
	    }
	    
	    return sortedList;
	}
	
	private ListNode insert(ListNode list, int val) {
	    ListNode head = list;
	    ListNode tail = list;
	    ListNode newNode = new ListNode(val);
	    if (head.val > newNode.val) {
	        //System.out.println("Inserting " + val + " at head");
	        newNode.next = head;
	        head = newNode;
	    } else {
	        while (tail.next != null && tail.next.val < newNode.val) {
	            tail = tail.next;
	        }
	        //System.out.println("Inserting " + val + " after " + tail.val);
	        newNode.next = tail.next;
	        tail.next = newNode;
	    }
	    return head;
	}
}

/**
Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3
**/
