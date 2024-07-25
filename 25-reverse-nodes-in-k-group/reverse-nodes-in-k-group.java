/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int ct = 0;

        // Just see if this block is reversible or not 
        while(curr!=null && ct<k){
            curr = curr.next;
            ct++;
        }

        // Come back to start of this block
        curr = head;

        // If block is reversible, reverse this block
        if (ct==k){
            ct = 0;
            while(curr!=null && ct<k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                ct++;
            }
        }
        // If block is not reversible then make prev wala pointer as head of this block
        else{
            prev = head;
        }

        // If block is reversible then iss block ke head ka next is next block ka head (think diagram wise) (since reverse hora blockwise)
        // iss code se reversed blocks connect ho rahe hai
        if (next!=null){
            head.next = reverseKGroup(next, k);
        }

        // block ka last element (before reversing) now becomes first ele
        // iss code se each reversed block ka first element milra hai (which is actually the element at prev index while reversing)
        return prev;
    }
}