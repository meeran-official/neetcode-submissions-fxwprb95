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

 /*
            
    0 < 1 < 2 < 3 < 4 
    h
                    n


    
    

 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null
        ListNode newHead = head;
        if(head.next != null) {
            newHead = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }
}
