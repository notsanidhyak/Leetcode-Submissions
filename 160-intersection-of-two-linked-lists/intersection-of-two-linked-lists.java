/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode b = headB;
        while(b!=null){
            ListNode a = headA;
            while(a!=null){
                if(a==b) return a;
                a = a.next;
            }
            b = b.next;
        }
        return null;
    }
}