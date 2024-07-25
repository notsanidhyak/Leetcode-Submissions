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
        while(curr!=null && ct<k){
            curr = curr.next;
            ct++;
        }
        curr = head;
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
        else{
            prev = head;
        }
        if (next!=null){
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
}