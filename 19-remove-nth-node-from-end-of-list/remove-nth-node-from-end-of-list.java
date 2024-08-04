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
        ListNode copy = head;
        ListNode curr = head;
        int ct = 0;
        while(curr!=null){
            curr = curr.next;
            ct++;
        }
        // if(ct==1 && n==1){
        //     return null;
        // }
        if(ct==n){
            return copy.next;
        }
        for(int i = 0; i<(ct-n-1); i++){
            head = head.next;
        }
        System.out.println(head.val);
        if (head.next!=null){
            head.next = head.next.next;
        }
        return copy;
    }
}