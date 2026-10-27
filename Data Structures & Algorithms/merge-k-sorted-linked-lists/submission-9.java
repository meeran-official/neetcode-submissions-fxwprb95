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
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode conquer(ListNode left, ListNode right) {
        ListNode res = new ListNode(-1), cur = res;
        while(left != null && right != null) {
            if(left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : (right != null ? right : null);
        return res.next;
    }

    private ListNode divide(ListNode[] lists, int l, int r) {
        if(l > r) return null;
        if(l == r) return lists[l];
        int m = l + (r - l) / 2;
        ListNode left = divide(lists, l, m);
        ListNode right = divide(lists, m + 1, r);
        return conquer(left, right);
    }

}
