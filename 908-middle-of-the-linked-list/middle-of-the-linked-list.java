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
    public ListNode middleNode(ListNode head) {
        // ListNode curr = head;
        // int l = 0;
        // while(curr!=null){
        //     curr = curr.next;
        //     l++;
        // }
        // ListNode mid = head;
        // for (int i = 0; i<l/2; i++){
        //     mid = mid.next;
        // }
        // return mid;

        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}