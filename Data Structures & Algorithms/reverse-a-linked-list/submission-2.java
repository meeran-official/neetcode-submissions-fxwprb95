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
    h
    0   1   2   3   4
                l   m   r

    IF head == null: return null
    IF head.next == null: return head

    l = null
    m = h
    r = m.next
    
    LOOP r is not null:
        m.next = l
        l = m
        m = r
        r = r.next
    m.next = l
    return m;
    

 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode l = null;
        ListNode m = head;
        ListNode r = m.next;

        while(r != null) {
            m.next = l;
            l = m;
            m = r;
            r = r.next;
        }
        m.next = l;
        return m;
    }
}
