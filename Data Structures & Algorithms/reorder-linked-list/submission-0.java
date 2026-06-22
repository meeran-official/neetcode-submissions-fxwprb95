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

    
 
    c = head
    l = head
    r = reverseSecondHalf(head)

    LOOP l != r
        l = l.next
        c.next = r
        c = c.next
        r = r.next
        c.next = l
        c = c.next

    reverseSecondHalf(head)
        mid = findMid(head)

        return reverse(mid)

    reverse(head)
        pre = null
        cur = head
        post = cur.next

        LOOP post is not null
            cur.next = pre
            pre = cur
            cur = post
            post = post.next
        
        cur.next = prev
        return cur

    findMid(head)
        fast = head
        slow = head

        LOOP fast and fast.next is not null
            slow = slow.next
            fast = fast.next.next
        return slow
    
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode cur = head;
        ListNode left = head;
        ListNode right = reverseSecondHalf(head);

        while(right.next != null) {
            left = left.next;
            cur.next = right;
            cur = cur.next;
            right = right.next;
            cur.next = left;
            cur = cur.next;
        }
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode post = cur.next;

        while(post != null) {
            cur.next = pre;
            pre = cur;
            cur = post;
            post = post.next;
        }
        cur.next = pre;
        return cur;
    }

    private ListNode reverseSecondHalf(ListNode head) {
        ListNode mid = getMid(head);
        return reverse(mid);
    }
}
