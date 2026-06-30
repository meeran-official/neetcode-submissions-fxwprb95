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
        ListNode head = new ListNode(-1), cur = head;
        int minVal, minIdx = 0;
        while(true) {
            minVal = Integer.MAX_VALUE; //resets, other way?
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null && lists[i].val < minVal) {
                    minVal = lists[i].val;
                    minIdx = i;
                }
            }
            if(minVal == Integer.MAX_VALUE) break;
            cur.next = lists[minIdx];
            cur = cur.next;
            lists[minIdx] = lists[minIdx].next;
        }
        return head.next;
    }
}
