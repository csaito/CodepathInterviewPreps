//https://www.interviewbit.com/problems/palindrome-list/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        int length = getListLength(A);
        int[] half = new int[length/2];
        for (int i = 0; i < half.length; i++) {
            half[i] = A.val;
            A = A.next; // populated till half
            //System.out.println("half array adding " + half[i]);
        }
        if (length % 2 == 1) { // odd number - skip one item
            A = A.next;
        }
        for (int i = half.length-1; i >= 0; i--) {
            //System.out.println("half array checking " + half[i] + " with " + A.val);
            if (half[i] != A.val) {
                return 0;
            }
            A = A.next;
        }
        return 1;
    }
    int getListLength(ListNode A) {
        if (A == null) {
            return 0;
        }
        int count = 1;
        ListNode node = A;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}

/**
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes: 
- Expected solution is linear in time and constant in space.

For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.
**/
