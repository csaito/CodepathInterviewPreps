//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/

public class Solution {
	public ListNode deleteDuplicates(ListNode a) {
	    if (a == null) {
	        return a;
	    }
	    ListNode tail = a;
	    int num = tail.val;
	    while (tail.next != null) {
	        if (tail.next.val == num) {
	            //System.out.println("removing duplicate " + tail.next.val);
	            tail.next = tail.next.next;
	        } else {
	            tail = tail.next;
	            //System.out.println("setting next var " + tail.val);
	            num = tail.val;
	        }
	    }
	    return a;
	}
}


/**
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
**/
