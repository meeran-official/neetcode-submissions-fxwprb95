class LinkedList {

    Node head;
    Node tail;

    public LinkedList() {
        head = new Node(-1);
        tail = head;
    }

    public int get(int index) {
        int i = 0;
        Node cur = head.next;

        while(cur != null && i < index) {
            cur = cur.next;
            i++;
        }

        if(cur != null) {
            return cur.val;
        }

        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);

        newNode.next = head.next;
        head.next = newNode;

        if(newNode.next == null) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);

        tail.next = newNode;
        tail = tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        Node cur = head;

        while(i < index && cur.next != null) {
            i++;
            cur = cur.next;
        }

        if(cur.next != null) {
            if(cur.next == tail) {
                tail = cur;
            }
            cur.next = cur.next.next;
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();

        Node cur = head.next;

        while(cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }

        return res;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this(val, null);
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}


