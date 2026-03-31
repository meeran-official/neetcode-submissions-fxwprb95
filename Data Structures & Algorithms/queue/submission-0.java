class Deque {
    private Node head, tail;

    public Deque() {
        head = new Node(-1);
        tail = head;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void append(int value) {
        Node node = new Node(value);

        tail.next = node;
        node.prev = tail;
        tail = tail.next;
    }

    public void appendleft(int value) {
        Node node = new Node(value);

        node.prev = head;
        node.next = head.next;
        
        if(head.next != null) {
            head.next.prev = node;
        } else {
            tail = node;
        }
        head.next = node;
    }

    public int pop() {
        if(isEmpty()) return -1;

        Node cur = tail;
        tail = tail.prev;
        tail.next = null;
        cur.prev = null;

        return cur.val;
    }

    public int popleft() {
        if(isEmpty()) return -1;

        Node cur = head.next;
        cur.prev = null;
        head.next = cur.next;
        cur.next = null;

        if(head.next != null) {
            head.next.prev = head;
        } else {
            tail = head;
        }

        return cur.val;
    }
}

class Node {
    private int val;
    private Node next;
    private Node prev;

    public Node(int val) {
        this.val = val;
    }
}