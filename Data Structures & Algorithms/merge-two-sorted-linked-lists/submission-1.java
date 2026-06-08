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
    t1
    1   2   4

-1

    1   3   4
    c   t2

head AND c = ListNode(-1, null)

t1 = list1
t2 = list2

LOOP t1 AND t2 is not null
    IF t1 < t2:
        c.next = t1
        t1 = t1.next
    ELSE
        c.next = t2
        t2 = t2.next
    c = c.next

IF t1 is null:
    c.next = t2
ELSE
    c.next = t1

return head.next


*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1, null);
        ListNode c = head;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                c.next = l1;
                l1 = l1.next;
            } else {
                c.next = l2;
                l2 = l2.next;
            }
            c = c.next;
        }

        c.next = l1 != null ? l1 : l2;
        return head.next;
    }   
}