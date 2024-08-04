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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        boolean flag = false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                flag = true;
                break;
            }
        }
        if(flag==true){
            HashMap<ListNode, Integer> map = new HashMap<>();
            int i = 0;
            while(true){
                if(map.containsKey(head)) return head;
                map.put(head, i);
                head = head.next;
                i++;
            }
        }
        return null;
    }
}