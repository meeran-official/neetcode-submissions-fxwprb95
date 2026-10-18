class ListNode {
    int val;
    ListNode prev;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
class MyLinkedList {
    int size;
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    private ListNode getPrevNode(int index) {                
        if(index <= size / 2) {
            ListNode cur = head;
            for(int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        }
        ListNode cur = tail;
        for(int i = 0; i < size - index + 1; i++) {
            cur = cur.prev;
        }
        return cur;
    }
    
    public int get(int index) {
        if(index >= size) return -1;
        return getPrevNode(index).next.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        ListNode newNode = new ListNode(val);
        ListNode prev = getPrevNode(index);
        ListNode next = prev.next;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return;
        ListNode prev = getPrevNode(index);
        prev.next.next.prev = prev;
        prev.next = prev.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */