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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headcopy = head;
        ListNode curr = head;
        int ct = 0;
        while(curr!=null){
            curr = curr.next;
            ct++;
        }
        if(ct==n) return headcopy.next;
        for(int i = 0; i<(ct-n-1); i++){
            head = head.next;
        }
        if (head.next!=null) head.next = head.next.next;
        return headcopy;
    }
}