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
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int minVal;
        int minIdx;
        while(true) {
            minVal = Integer.MAX_VALUE;
            minIdx = -1;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] == null) continue;
                if(lists[i].val < minVal) {
                    minVal = lists[i].val;
                    minIdx = i;
                }
            }
            if(minIdx == -1) break;
            cur.next = lists[minIdx];
            cur = cur.next;
            lists[minIdx] = lists[minIdx].next;
        }
        return head.next;
    }
}
