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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate length of linked list
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // To take care of k > len of LL
        temp.next = head;
        k = k % length;
        k = length - k;

        // Do the changes
        while (k-- > 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;

        // Return the new head
        return head; 
    }
}