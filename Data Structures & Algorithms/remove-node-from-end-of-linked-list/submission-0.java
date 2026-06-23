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
 
 size = getSize(head)
 n = size - n;
 cur = head
 i = 0

 LOOP i < n - 1
    cur = cur.next   
    i++
cur.next = cur.next.next

getSize(head)
    f = s = head
    size = 0
    LOOP f and f.next is not null
        s = s.next
        f = f.next.next
        size++
    if f is not null
        size++
    return size
    
 
 
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(head.next == null) return null;
        int size = getSize(head);
        n = size - n;
        ListNode cur = head;
        for(int i = 0; i < n - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    private int getSize(ListNode head) {
        ListNode f, s;
        f = s = head;
        int size = 0;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            size++;
        }
        size *= 2;
        if(f != null) {
            size++;
        }
        return size;
    }
}



















