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
 
    0   1   2   3   4   5   6   7   8   9   10
                                        s   
                                            f

    1   2   3   4
                s
                f      
                                          

    f = s = head    
    
    LOOP f is null OR f.next is null
        s = s.next
        f = f.next.next
        IF s == f
            return true    
    return false
        
 
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if(s == f) return true;
        }
        return false;
    }
}
