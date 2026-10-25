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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists) {
            if(list == null) continue;
            minHeap.offer(list);
        }
        ListNode head = new ListNode(-1), cur = head;
        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;
            node = node.next;
            if(node == null) continue;
            minHeap.offer(node);
        }
        return head.next;
    }
}
