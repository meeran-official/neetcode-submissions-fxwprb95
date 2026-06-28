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
 if head is null or head.next is null
    return null

 l = r = ListNode(-1)
 r.next = head
 i = 0
 loop i < n
    r = r.next
    i++

loop r.next is not null
    l = l.next
    r = r.next
l.next = l.next.next
 
 
 
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        ListNode l = new ListNode(-1, head), r = l;
        head = l;
        for(int i = 0; i < n; i++) {
            r = r.next;
        }
        while(r.next != null) {
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;
        return head.next;
    }
}
