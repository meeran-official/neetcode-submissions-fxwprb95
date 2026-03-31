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

class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null) return head;

        ListNode left = null;
        ListNode cur = head;
        ListNode right = head.next;

        while(cur != null) {
            cur.next = left;
            
            left = cur;
            cur = right;

            if(right != null) {
                right = right.next;
            }
        }

        return left;
    }
}
