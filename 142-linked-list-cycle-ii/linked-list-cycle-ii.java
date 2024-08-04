/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Brute Force -

// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         if(head==null || head.next==null) return null;
//         boolean flag = false;
//         ListNode fast = head;
//         ListNode slow = head;
//         while(fast.next!=null && fast.next.next!=null){
//             fast = fast.next.next;
//             slow = slow.next;
//             if(fast==slow){
//                 flag = true;
//                 break;
//             }
//         }
//         if(flag==true){
//             HashMap<ListNode, Integer> map = new HashMap<>();
//             int i = 0;
//             while(true){
//                 if(map.containsKey(head)) return head;
//                 map.put(head, i);
//                 head = head.next;
//                 i++;
//             }
//         }
//         return null;
//     }
// }

// ---------------------------------------------------------------

// Optimized Approach -

// L1 (dist from start of ll to start point of cycle)
// L2 (dist from start point of cycle to meeting point)
// C (length of cycle)
// slow pointer covers L1+L2 dist
// fast pointer covers L1+L2+nC dist (nC since wo cycle karte rahega jab tak slow pointer aa nahi jaata)
// we know fast pointer covers 2x the slow pointer
// hence, L1+L2+nC = 2(L1+L2)
// this gives L1 = nC-L2 meaning - (1) ki intersection hai + (2) L1+L2 = C
// THINK!

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                while(head!=slow){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}