class Node {
    int val;
    Node next;
    Node prev;
    Node(int val) {
        this.val = val;
    }
    Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    long size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index >= size) return -1;
        Node cur = head;
        while(index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val, head, null);
        if(head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        if(head == null) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val, null, tail);
        
        tail.next = newNode;
        tail = tail.next;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == size) {
            addAtTail(val);
            return ;
        }
        if(index == 0) { 
            addAtHead(val);
            return;
        }
        Node cur = head;
        while(index-- > 1) {
            cur = cur.next;
        }
        Node temp = cur.next;
        Node newNode = new Node(val, temp, cur);
        temp.prev = newNode;
        cur.next = newNode;
        size++;
    }

    private void removeAtTail() {
        if(tail == null) return;
        tail = tail.prev;
        if(tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }

    private void removeAtHead() {
        if(head == null) return;
        head = head.next;

        if(head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return;
        if(index == size - 1) {
            removeAtTail();
            return;
        }
        if(index == 0) {
            removeAtHead();
            return;
        }
        Node cur = head;
        while(index-- > 1) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        if(cur.next.next != null) {
            cur.next.next.prev = cur;
        }
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