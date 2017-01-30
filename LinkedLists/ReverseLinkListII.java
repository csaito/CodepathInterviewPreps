//https://www.interviewbit.com/problems/reverse-link-list-ii/

public class Solution {
	public ListNode reverseBetween(ListNode a, int m, int n) {
	    ListNode head = a;
	    int count = 1;
	    if (m == count) {
	        a = reverse(head, n-m);
	    } else {
	        while (count < m-1 && head != null) {
	            head = head.next;
	            count++;
	        }
	        head.next = reverse(head.next, n-m);
	    }
	    return a;
	}
	private ListNode reverse(ListNode a, int nodeCount) {
	    //System.out.println("reversing starting at " + a.val);
	    if (nodeCount == 0) {
	        return a; 
	    } else {
	        ListNode newTail = a;
	        ListNode prevNode = a;
	        ListNode currNode = prevNode.next;
	        ListNode nextNode = currNode.next;
	        int count = 0;
	        while (count < nodeCount) {
                //System.out.println("reversing " + prevNode.val + " " + currNode.val + " " + (nextNode == null ? "null" : nextNode.val));
	            currNode.next = prevNode;
	            prevNode = currNode;
	            currNode = nextNode;
	            nextNode = (nextNode == null ? null : nextNode.next);
	            count++;
	        }
            //System.out.println("final adjustment " + newTail.val + " to " + (currNode == null ? "null" : currNode.val) + " returning " + prevNode.val);
	        newTail.next = currNode;
	        return prevNode;
	    }
	}
}

/**

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question. 

**/
