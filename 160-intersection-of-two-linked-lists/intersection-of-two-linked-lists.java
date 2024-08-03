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

// ---------------------------------------------------------------------

// Brute Force Approach -> worst n^2

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode b = headB;
//         while(b!=null){
//             ListNode a = headA;
//             while(a!=null){
//                 if(a==b) return a;
//                 a = a.next;
//             }
//             b = b.next;
//         }
//         return null;
//     }
// }

// ---------------------------------------------------------------------

// Optimized approach -> worst case m+n

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode a = headA;
//         ListNode b = headB;
//         while(a!=b){
//             if(a==null) a = headA;
//             else a = a.next;
//             if(b==null) b = headB;
//             else b = b.next;
//         }
//         return a;
//     }
// }

// ---------------------------------------------------------------------

// Beats 100% -> m+n only (ct method)

public class Solution{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ctA = 0;
        int ctB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        while(currA!=null){
            ctA++;
            currA = currA.next;
        }
        while(currB!=null){
            ctB++;
            currB = currB.next;
        }
        while(ctA>ctB){
            headA = headA.next;
            ctA--;
        }
        while(ctB>ctA){
            headB = headB.next;
            ctB--;
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}